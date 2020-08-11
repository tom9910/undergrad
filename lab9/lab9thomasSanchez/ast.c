//Thomas Sanchez
//lab9 
//05-08-20
//to connect ast.c and lab6.y and create a parse tree.


#include "ast.h"
#include <stdio.h>
#include <stdlib.h>
//#include <malloc.h>

ASTNode * CreateASTNode(enum NODETYPE DesiredType){
    
        struct ASTNodeType * p;
        
        p = (struct ASTNodeType *)(malloc (sizeof(struct ASTNodeType)));
        p->Type = DesiredType;
        p->s1 = NULL;
        p->s2 = NULL;
        p->next = NULL;
        
        p->value = 0;
        
        return p;
    
}// of create node

//function to check paramter matching
//returns 1 if ok
int checkFormalsAndparams(ASTNode *f, ASTNode *a){
    if((f == NULL) && (a == NULL)) return 1;
    if((f == NULL) || (a == NULL)) return 0;
    
    if((f->semanticType) != (a->semanticType)) return 0;
    
    return checkFormalsAndparams(f -> next, a ->next);
}

int Level = 0;

//print function for printing indents based on current level
void PT(int num){
    for(int i = 0; i < num; i++)
        printf("    ");
}// of indent fucntion

void ASTprint(ASTNode *p, int level){
     //printf("i am here \n");
   
    if(p == NULL) return; //out
    
    PT(Level); //prints indent for level before case
    
    switch(p->Type){                    //switch case for value return from yacc
            
        case VAR:
             printf("IDENTIFIER ");
            if(p->value == 0){
                printf("%s\n", p->name);
            }// of if only one
            else{
                printf("%s\n", p->name);
                PT(level);
                printf("array Refrence [\n");           //show if array
                
                ASTprint(p->s1, level);
                ASTprint(p->s2, level);
                PT(Level);
                printf("] end of array \n");
            } // of else
            
       
            break;
        
        case VARDEC: 
                     printf("Variable ");
                     
                     //print typespec
                     if(p->operator == INTTYPE)
                         printf("INT");
                     if(p->operator == BOOLTYPE)
                         printf("BOOLEAN");
                     if(p->operator == VOIDTYPE)
                         printf("VOID");
                     
                     
                     printf(" %s", p->name);
                     
                     if(p->value > 1){
                     printf("[%d] \n", p->value);
                     }// if array
                     else{printf("\n");}
                     
                     ASTprint(p->s1, level);
                     break;
                     
        case FUNDEC: 
                    //print tyspec
                     if(p->operator == INTTYPE)
                         printf("INT");
                     if(p->operator == BOOLTYPE)
                         printf("BOOLEAN");
                     if(p->operator == VOIDTYPE)
                         printf("VOID");
            
                    printf(" FUNCTION %s \n", p->name);
            
                    if (p->s1 == NULL) printf("(VOID) \n");
                    else{  printf("(\n");
                            //print parameters
                            ASTprint(p->s1, level);
                         
                         printf(")\n");
                    }
            
                    
                ASTprint(p->s2, level + 2);
                     
                    
            
        break;
            
        case PARAM:
                printf("PARAMETER ");
                //print typespec of parameters
                if(p->operator == INTTYPE)
                         printf("INT");
                     if(p->operator == BOOLTYPE)
                         printf("BOOLEAN");
                     if(p->operator == VOIDTYPE)
                         printf("VOID");
                printf(" %s", p->name);
                 if(p->value > 1){
                     printf("[%d] \n", p->value);
                     }// if array
                     else{printf("\n");}
                
            break;
            
        case CMPSTMT: printf("BLOCK STATEMENT \n");   //print on begin in function
            
                    ASTprint(p->s1, level + 1);
                    ASTprint(p->s2, level + 1);
        
        break;
            
        case myWRITE: printf("WRITE STATEMENT \n");
                if(p->s1 != NULL){
                      ASTprint(p->s1, level + 1);  
                }
                else{   //is a string
                    printf("with the string %s %s \n",p->label, p->name);
                }
                      
            break;
            
            
        case myREAD: printf("READ STATEMENT \n");
                    
                     ASTprint(p->s1, level + 1);
                     ASTprint(p->s2, level + 1);
            break;
            
        case myNUM: printf("number WITH VALUE ");
                    printf("%d \n", p->value);
            
                    ASTprint(p->s1, level + 1);
                    ASTprint(p->s2, level + 1);
            break;
            
        case EXPR: printf("EXPR  ");
                   
                    //print operator based on found operator from yacc      
                    switch(p->operator){
                       case PLUS: printf(" + \n");
                                  break;
                       case MINUS: printf(" - \n");
                                   break;
                        case MULT: printf(" * \n");
                        break;
                        
                        case DIV: printf(" / \n");
                            break;
                        case MYAND: printf(" and \n");
                            break;
                        case MYOR: printf(" or \n");
                            break;
                        case myGE: printf(" >= \n");
                            break;
                        case myLE: printf(" <= \n");
                            break;
                        case myNE: printf(" != \n");
                            break;
                        case myEE: printf(" == \n");
                            break;
                        case GT:   printf(" > \n");
                            break;
                        case LT:   printf(" < \n");
                            break;
                        case MYNOT: printf(" not \n");
                            break;
                       default: printf("unknow expression operator\n"); // if operator isnt recognized
                       
                   }//of switch opertor
                    
                    ASTprint(p->s1, level +1);              
                    ASTprint(p->s2, level +1);
                    
            
                    
            break;
            
        case myWHILE: printf("WHILE STATEMENT\n");
                  
                  ASTprint(p->s1, level + 1);
                  ASTprint(p->s2, level + 1);    
            
            break;
        
        case ASSGINSTMT: printf("Assignment STATEMENT\n");
            
                ASTprint(p->s1, level + 1);
                ASTprint(p->s2, level + 1);
            
               
            break;
            
        case EXPRSTMT: printf("EXPRSTMT\n");
                ASTprint(p->s1, level + 1);
                ASTprint(p->s2, level + 1);
            
            break;
            
        case IFTHEN:
                
                printf("IF \n");
                PT(level); printf("(\n");
            
                ASTprint(p->s1, level + 1);
                PT(level); printf(")\n");
                PT(level); printf("THEN\n");
                ASTprint(p->s2->s1, level+2);
            
                 if (p->s2->s2 != NULL){    //contine if if else statement
                    PT(level + 1);
                    printf("ELSE\n");
                    ASTprint(p->s2->s2, level+2);
                }
                
                
            break;
            
        case FUNCCALL: 
                printf("CALL ");
                printf("%s\n", p->name);
                ASTprint(p->s1,level+1);
            break;
            
        case ARGS:
                printf("ARG \n");
          
                    ASTprint(p->s1, level);
               
            break;
            
            
        case RET: printf("RETURN\n");
                    if(p->value > 0){
                        ASTprint(p->s1, level+1);
                    }
            break;
        default: printf("unknown type in ASTprint \n"); //if type does not match any cases
            
        
    }// of switch
   
    ASTprint(p->next, level);
}
