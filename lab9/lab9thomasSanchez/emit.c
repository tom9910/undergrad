
//Thomas Sanchez
//lab9
//05-08-20
// lab9 changes: PRODUCE MIPS CODE add strings




#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <string.h>
#include "ast.h"
#include "emit.h"

char * Cur_func;

static int GLABEL = 0;

char * genlabel()
{  char s[100];
   char *s1;
   sprintf(s,"_L%d",GLABEL++);
   s1=strdup(s);  // get heap memory for the label name
   return (s1);
}

//pre: ptr to string type from yacc
//post: mips code to declare a string
void EmitStrings(ASTNode * p, FILE * fp){
        if(p == NULL) return;
    
        if((p->Type == myWRITE) && (p->name != NULL))
           fprintf(fp, "%s:\t .asciiz\t%s\n", p->label, p->name);
    
        EmitStrings(p->next, fp);
        EmitStrings(p->s1, fp);
        EmitStrings(p->s2, fp);
}// of emit strings

//post emits mips global varibles
void EMITGLOBALS(ASTNode * p, FILE * fp){
    if(p == NULL) return;
    
    if((p->Type == VARDEC) && (p->symbol->level == 0))
           fprintf(fp, "%s:\t .space\t%d\n", p->name, p->symbol->mysize*WSIZE);
    
        EMITGLOBALS(p->next, fp);
        EMITGLOBALS(p->s1, fp);
       //  no global vardecs through s2
}// of emit globals



//helper function to make clean mips code
//take four params and print function
//precondition given three strings

void emit(FILE *fp, char *Label, char * command, char * comment){
    
    if(strcmp("", Label) == 0) fprintf(fp, "\t%s\t\t%s\n",command,comment);
    else
    fprintf(fp, "%s:%s\t\t%s\n", Label,command,comment);
    
    
}// of emit

//precondition ptr to fundec
//post code written to mips

void emit_function_head(ASTNode * p, FILE * fp){
    char s[100];
    
    
    emit(fp,p->name,"","#start of function");
    
    //global function var
    Cur_func = p->name;
    
    //make stack pointer move
    
    sprintf(s,"\n\tsubu $a0, $sp, %d \n\tsw $sp, ($a0) \n\tsw $ra, 4($a0) \n\tmove $sp, $a0",p->value*WSIZE);
    emit(fp,"", s,"#adjust stack pointer\n" );
    
    
}// of emit function head

//emit identifier prepares mips code for use of arrays and scalars, both local and global
void emit_identifier(ASTNode * p, FILE *fp){
    char s[100];
    if(p->symbol == NULL) return;
    
    
    
    //check if VAR is global
    if(p->symbol->level == 0){
        if(p->s1 != NULL){
            //array
            sprintf(s, "la $t0, %s", p->name);
            emit(fp, "", s, "#global array");
            
            emit_expr(p->s1, fp);
            sprintf(s, "sll $a0, $a0, %d", 2*WSIZE);
           emit(fp, "", s ,"");
            emit(fp, "", "add $a0, $a0, $t0", "");
            //more
        }
        else{
        //global scalar
        sprintf(s, "la $a0, %s", p->name);
        emit(fp, "", s, "#global indentifier");
        }//of else scalar
    }
    else{//if local
        if(p->s1 != NULL){
            emit_expr(p->s1, fp);
             sprintf(s, "sll $a0, $a0, %d", 2*WSIZE);
           emit(fp, "", s ,"");
            sprintf(s, "add $a0, $a0, %d",  p->symbol->offset * WSIZE );
            emit(fp, "", s, "");
            emit(fp, "", "add $a0, $a0, $sp", "");
            
        }// if array
      else{  
        //add $a0, %d
            sprintf(s, "add $a0, $sp, %d", p->symbol->offset * WSIZE);

            emit(fp,"", s, "#identifier is a local scalar\n\n");
      }
    }
    
    //check if VAr is scalar or array
    //do two more
    
    
    
}//of emit identifier
       

//Precondition a ptr yo an expression "factor defined in the yacc language
//Post: mips that set $a0 to the value of ptr

void emit_expr(ASTNode * p, FILE * fp){
    
    char s[100];
    //base case(s)
    switch(p->Type){
        case myNUM:
            
            sprintf(s, "li $a0, %d", p->value);
            emit(fp,"",s, "# expression is a number");
            return;
            break; //for reading
        case VAR:
            emit_identifier(p, fp);
            emit(fp, "", "lw $a0, ($a0)", "#fetch value");
            
            return;
            break; //for read
            exit(1);
         
        //case CALL:
            //emit_call(p,fp);
           // return;
            
    }// of switch
    
    if(p->Type != EXPR) return;
    //expression is an expr deal with recursion
    //evaluate s1
    emit_expr(p->s1, fp);
    
    // store s1 in p->symbol->offset
    sprintf(s, "sw $a0 %d($sp)", p->symbol->offset *WSIZE);
    emit(fp,"", s , "# store into offset");
    
    if(p->s2 != NULL){ 
    //evaluate s2
    emit_expr(p->s2, fp);
    
    //move a0 to a1
    emit(fp,"", "move $a1, $a0", "");
}// of if s2 exsists
    //laod a0 with p->symbol->offset
    sprintf(s, "lw $a0 %d($sp)", p->symbol->offset *WSIZE);
    emit(fp, "", s, "#load a0");
    
    //perform calculations
    switch(p->operator){
                        case PLUS: 
                                 emit(fp, "", "add $a0, $a0, $a1", "#expr ADD");
                                  break;
                       case MINUS: emit(fp, "", "sub $a0, $a0, $a1", "#expr sub");
                                   break;
                        case MULT: emit(fp, "", "mult $a0 $a1", "#expr mult");
                                    emit(fp, "", "mflo $a0", "#expr mult");
                            break;
                        
                        case DIV: emit(fp, "", "div $a0 $a1", "#expr mult");
                                    emit(fp, "", "mflo $a0", "#expr mult");
                            break;
                        case MYAND: 
                                   emit(fp, "", "and $a0, $a0, $a1", "# and");
                            break;
                        case MYOR: 
                                     emit(fp, "", "or $a0, $a0, $a1", "#or");
                            break;
                        case myGE: printf(" >= \n");
                                  emit(fp,"", "sge $a0, $a0, $a1", "#set greater o reqaul to" );
                            break;
                        case myLE: printf(" <= \n");
                                    emit(fp,"", "sle $a0, $a0, $a1", "#set less thean or eqaul to" );
                            break;
                        case myNE: 
                                    emit(fp,"", "sne $a0, $a0, $a1", "#set  not eqaul to" );
                            break;
                        case myEE: 
                                    emit(fp,"", "seq $a0, $a0, $a1", "#set eqaul to ");
                            break;
                        case GT:   printf(" > \n");
                                    emit(fp,"", "sgt $a0, $a0, $a1", "#set greater than");
                            break;
                        case LT:   printf(" < \n");
                                   //emit(fp, "", "sub $a0, $a0, $a1", "#expr sub");
                                   emit(fp,"", "slt $a0, $a0, $a1", "#set less than");
                            break;
                        case MYNOT: printf(" not \n");
                                    emit(fp, "", "sltiu $a0, $a0 1", "#not comparison");
                            break;
                       default: printf("unknow expression operator\n"); 
    }//of operator switch
    
}// of emit expression

//precondition a ptr to a while factor from yacc
//post mipps code produced to run a while do statment

void emit_while(ASTNode * p, FILE * fp){
   
    char s[100];
    char *L1, *L2;
    
    L1 = genlabel();
    L2 = genlabel();
    
    sprintf(s, "%s", L1);
    emit(fp, s, "", "#loop start" );
    
    emit_expr(p->s1, fp);                   
    emit(fp, "", "li $t1, 0", "");
    
    
    
    sprintf(s, "beq $a0, $t1, %s", L2);
    emit(fp, "", s, "#if not true" );
    
    EMITAST(p->s2, fp);
    fprintf(fp, "\tj %s\n", L1);
    
    
    
    sprintf(s, "%s", L2);
    emit(fp, s, "nop", "#end of if section\n");
    
    
}// of emit while

void emit_if(ASTNode * p, FILE * fp){
    char s[100];
    char *L1, *L2;
    
    L1 = genlabel();
    L2 = genlabel();
    
    emit_expr(p->s1, fp);                   
    emit(fp, "", "li $t0, 0", "");
    sprintf(s, "beq $a0, $t0, %s", L1);
    emit(fp, "", s, "#if not true" );
    
    EMITAST(p->s2->s1, fp);
    fprintf(fp, "\tj %s\n", L2);
    
    sprintf(s, "%s", L1);
    emit(fp, s, "", "#else section" );
    EMITAST(p->s2->s2, fp);
    
    sprintf(s, "%s", L2);
    emit(fp, s, "nop", "#end of if section\n");
    
}//emit if


//precondition a ptr to assignment statment
//post: mips code storing value into indetifier
void emit_assignment(ASTNode *p, FILE *fp){
    char s[100];
    
    emit_identifier(p->s1, fp);
    sprintf(s, "sw $a0, %d($sp)", p->symbol->offset *WSIZE);
    emit(fp, "", s, "");
    emit_expr(p->s2, fp);
    sprintf(s, "lw $t0, %d($sp)", p->symbol->offset*WSIZE);
    emit(fp, "", s , "");
    emit(fp, "", "sw $a0, ($t0)", "");
}// of emit assignment
                                     
//precondition p is pointer to a VAR node
//post mips code such that $a0 is the address of where VAR is in memory


void emit_write(ASTNode * p,FILE * fp){
    char s[100];
    
    if(p->s1 != NULL){
    emit_expr(p->s1,fp);
    emit(fp,"", "li $v0 1", "# Print the number");
    emit(fp, "", "syscall", "# system call\n");
    }// of if
    else{
        emit(fp, "", "li $v0, 4", "");
        sprintf(s, "la $a0, %s", p->label);
        emit(fp, "", s , "");
        emit(fp, "", "syscall", "");
        emit(fp,"","",""); 
    }// of else
    
   
}// of wmit write

//pre condition:  ptr to READ
//pot condition: mips code to read from user and store in identifier
void emit_read(ASTNode * p,FILE * fp){
    char s[100];
     emit_identifier(p->s1, fp); //a0 is the address we want to store
    
    emit(fp, "", "li $v0, 5", "#read num from input");
    emit(fp, "", "syscall", "# system call\n\n"); 
    emit(fp,"", "sw $v0, ($a0)", "#store the read into a mem location\n\n");
    //we know $v0 has value read in
    
    
    
}//of emit read

//emit return 
//to handle explicit and implicit function returns
//precondition ptr to return or null
//post mips return code

void emit_function_return(ASTNode * p, FILE *fp){
    
    if(p != NULL){
        //eval the the expr
        emit_expr(p, fp);  //this leaves $a0 with the result
    }// if not null
    
    //if it is null we do nothing with a0
    
    emit(fp, "", "lw $ra, 4($sp)", "#restore RA");
    emit(fp, "", "lw $sp, ($sp)", "#restore SP\n");
    
    if(strcmp(Cur_func,"main") == 0){
        //handle main returnd
        emit(fp,"", "li $v0, 10", " #leave Main program");
        emit(fp, "", "syscall", "#leave main");
        emit(fp, "", "sw $v0 ($a0)", "#store the REad into a mem location");
    }// of if amin
    
    else{
        //jump back to ra
    }// of anyother function
    
}// of emit return

//pre: takes an ast tree 
// post: outputs in mips code in fp
//

void EMITAST(ASTNode * p, FILE * fp){
    if(p == NULL) return;
    
    switch(p->Type){
         
        case VARDEC: //nothing needed
                break;
        case FUNDEC: emit_function_head(p, fp);
                EMITAST(p->s2, fp); //the block
                
                emit_function_return(NULL, fp);
                break;
        case CMPSTMT: EMITAST(p->s2, fp);
                break;
        case myWRITE:
            
            emit_write(p, fp);
            break;
            
        case myREAD:
            emit_read(p, fp);
            break;
            
         case IFTHEN:
            emit_if(p, fp);
            
            break;  
                
        case myWHILE:
           
            emit_while(p, fp);
        
            break;
            
        case ASSGINSTMT:
            emit(fp, "", "", ""); 
            emit_assignment(p, fp);
            
            break;
        
            
            default: printf("Emit AST type not implemented\n");
      
    }// of switch 
    
    EMITAST(p->next,fp);
    
}// of emitast
