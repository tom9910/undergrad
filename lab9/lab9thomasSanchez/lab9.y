%{

/* 

//Thomas Sanchez
//lab9
//05-08-20
// lab9 changes: PRODUCE MIPS CODE add strings


*/



	/* begin specs */
	

	
int yylex();
#include "ast.h"
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include "symtable.h"
#include <string.h>
#include "emit.h"

int level = 0; //level of compund statements
int offset = 0;  //hold current offset

int GOFFSET; // hold global offset
    
int MAXOFFSET; // the max amount of memory needed for function

#define MAX_STACK 5			/* max amount of varibles allowed */

ASTNode *GlobalTreePointer; 

extern int mydebug;
extern int linecount;

int regs[MAX_STACK];
int base, debugsw;
int offset;
int count = 0;

void yyerror (s)  /* Called by yyparse on error */
     char *s;
{
  printf ("%s on line %d\n", s, linecount);
}


%}
/*  defines the start symbol, what values come back from LEX and how the operators are associated  */

%start program

%union{					//so yacc can recieve integer and string type from lex
    int number;
    char * string;
   
    struct ASTNodeType * node;
    enum OPERATORS operator;
}
//declare types of all nodes operators or tokens
%token <number> NUM
%token <string> ID STRING 
%token INT AND OR NOT VOID WHILE DO IF ELSE READ WRITE MYBEGIN THEN MYRETURN TRUE FALSE BOOLEAN END 
%token LE GE EE NE

%type <operator> typespec addop relop multop
%type <node> VarList vardec dec decls fundec compoundstmt params paramlist param statement stmtlist localdec writestmt args arglist 
%type <node> expression simpleExpr addExpr factor term readstmt var iterationstmt assignmentstmt exprstmt selectionstmt call returnstmt


%%	/* end specs, begin rules
	print when a num token is found.
	one shift reduce error in if else
 */

program : decls {GlobalTreePointer = $1;}
	;

decls   : dec   {$$ = $1;}
	|     dec decls {$1-> next = $2; $$ = $1;}
	;
dec     : vardec  {$$ = $1;}
    |     fundec   {$$ = $1;}
    ;
    
vardec : typespec VarList ';' {$$ = $2;
            ASTNode * p;
            
            p = $$;
            
            while( p!= NULL){
                p->operator = $1;
               // p->symbol->Type = $1;
                 Search(p->name,level,0)->Type = $1;   //set the symbol type 
                p = p->s1;
               
            }// of while


    }
    ;
VarList : ID { 
                /*search symbol table for ID*/
                
               
                if(Search($1, level, 0) != NULL){
                    yyerror("Duplicate variable");
                    yyerror($1);
                    exit(1);
                }//if id found
                else{
                    //insert the symbol
                    //char *name, enum OPERATORS Type, int isafunc, int  level, int mysize, int offset, ASTNode * fparms
                    Insert($1, -1, 0, level, 1, offset, NULL);
                    offset = offset + 1; //the size of the element
                    
                    //display for debugging
                    //Display();
                }// else not found
                
                
                $$ = CreateASTNode(VARDEC);
               
               
                $$->name = $1;
                $$->value = 1;
                 $$-> symbol = Search($1, level, 0);  //make the symbol of the node the correct symbol 
               
                
                } // of id
     | ID '[' NUM ']'{
         
             if(Search($1, level, 0) != NULL){
                    yyerror("Duplicate variable");
                    yyerror($1);
                    exit(1);
                }//if id found
         
             else{
                 Insert($1, -1, 2, level, 1, offset, NULL);
                 offset = $3;
                 
                // Display(); // for debug
             }// of not found
            
            $$ = CreateASTNode(VARDEC);
            $$->name = $1;
            $$->value = $3;
             $$-> symbol = Search($1, level, 0);  //make the symbol of the node the correct symbol 
             $$->symbol->mysize = $3;
            
     } // of id num 
     | ID ',' VarList {
         
            if(Search($1, level, 0) != NULL){
                    yyerror("Duplicate variable");
                    yyerror($1);
                    exit(1);
                }//if id found
                else{
                    //insert the symbol
                    //char *name, enum OPERATORS Type, int isafunc, int  level, int mysize, int offset, ASTNode * fparms
                    Insert($1, -1, 0, level, 1, offset, NULL);
                    offset = offset + 1; //the size of the element
                    
                    //display for debugging
                   // Display();
                }// else not found 
         
            $$ = CreateASTNode(VARDEC);
            $$->name = $1;
            $$->value = 1;
            $$-> symbol = Search($1, level, 0); //make the symbol of the node the correct symbol 
            $$->s1 = $3;
     
     } // of id , varlist
     | ID '[' NUM ']' ',' VarList {
            
         if(Search($1, level, 0) != NULL){
                    yyerror("Duplicate variable");
                    yyerror($1);
                    exit(1);
                }//if id found
         
             else{
                 Insert($1, -1, 0, level, 1, offset, NULL);
                 offset = $3;
                 
                 //Display(); // for debug
             }// of not found
         
            $$ = CreateASTNode(VARDEC);
            $$->name = $1;
            $$->value = $3;
         $$-> symbol = Search($1, level, 0); //make the symbol of the node the correct symbol 
            $$->s1 = $6;
         $$->symbol->mysize = $3;
     } // of id num , varlist
     
     ;
typespec : INT {$$=INTTYPE;}
        | VOID {$$=VOIDTYPE;}
        | BOOLEAN {$$=BOOLTYPE;}
    ;
    
fundec : typespec ID '('{
    
        //check if function anme has already been used
         if ( Search($2, level, 0) != NULL){
            yyerror("Duplicate variable");
                    yyerror($2);
                    exit(1);
        }// if exsists
        else{
            Insert($2, $1, 1, level, 0, 0, NULL);
            
        }/// of insert func 
    
         GOFFSET = offset; offset = 2; MAXOFFSET = offset;/*deals with offset before func*/} params ')' {
        
        Search($2,level,0)-> fparms = $5;   //this updates the formal paramtere link in my symbol table
            
         } compoundstmt 
        {
        
       
        $$ = CreateASTNode(FUNDEC);
        $$ -> operator = $1;
        $$->name = $2;
        $$ -> s1 = $5;
        $$->s2 = $8;
        $$->symbol = Search($2, level, 0);
        offset = GOFFSET;
        
        //store the size of the function
        Search($2, 0, 0)->mysize = MAXOFFSET;
        $$->value = MAXOFFSET;
        
        }// of typespec id param compoundstmt
    ;
    
params : VOID {$$ = NULL;}
    |   paramlist {$$ = $1;}
    ;
    
paramlist : param  {$$ = $1;}
        |   param ',' paramlist {$1 -> next = $3; $$ = $1;}
        ;
        
param : typespec ID { 
                    /*check if symbol table is there*/
                
                    if(Search($2, level + 1, 0) != NULL){
                    yyerror("Duplicate variable in parameter list");
                    yyerror($2);
                    exit(1);
                }//if id found
                    else{
                    //insert the symbol
                    //char *name, enum OPERATORS Type, int isafunc, int  level, int mysize, int offset, ASTNode * fparms
                    Insert($2, $1, 0, level + 1, 1, offset, NULL);
                    offset = offset + 1;
                   // Display();
                }// else not found
    
                     $$ = CreateASTNode(PARAM);
                     $$->operator = $1;
                     $$->name = $2;
                     $$->value = 0;
                     $$->semanticType = $1;   //set semantic type of param
}// of typespec id
    | typespec ID '[' ']'{
                    
                    //check to see if paramter already exsists at level
                     if(Search($2, level + 1, 0) != NULL){
                    yyerror("Duplicate variable in parameter list");
                    yyerror($2);
                    exit(1);
                }//if id found
                    else{
                    //insert the symbol
                    //char *name, enum OPERATORS Type, int isafunc, int  level, int mysize, int offset, ASTNode * fparms
                    Insert($2, $1, 2, level + 1, 1, offset, NULL);
                    offset = offset + 1;
                    //Display();
                }// else not found    
                        
        
                     $$ = CreateASTNode(PARAM);
                     $$->operator = $1;
                     $$->name = $2;
                     $$->value = -1;
                     $$->semanticType = $1; //set semantic type of param
    }// of typespec od []
    ;    
compoundstmt : MYBEGIN{level++;} localdec stmtlist END {
        $$ = CreateASTNode(CMPSTMT);
        
        $$-> s1 = $3;
        $$ -> s2 = $4;
        if(offset > MAXOFFSET) MAXOFFSET = offset;
        Display();  //shows name offset and level
        offset -= Delete(level);
        level--;
    
    }// of compund statment
    ;

localdec : vardec localdec {$1 -> next = $2; $$ = $1;}
        | /*empty*/{$$ = NULL;}
        ;
        
stmtlist : statement stmtlist {
            
            if($1 == NULL)
                $$ = $2;
                else{
            $1-> next = $2; $$ = $1;}
            }
        | {$$ = NULL;}
        ;
 //types of statements       
statement : exprstmt {$$ = $1;}
    | compoundstmt {$$ = $1;}
    | selectionstmt {$$ = $1;}
    | iterationstmt {$$ = $1;}
    | assignmentstmt {$$ = $1;}
    | returnstmt {$$ = $1;}
    | readstmt {$$ = $1;}
    | writestmt {$$ = $1;}
    ;

exprstmt : expression ';' {$$ = $1;
                           
                          }
        | ';' {//$$ = CreateASTNode(EXPRSTMT);
              }
        ;
 // if statements produces 1 shift reduce error       
selectionstmt : IF '('expression ')' THEN  statement  {
    
                $$ = CreateASTNode(IFTHEN);
                $$->s1 = $3;
                $$->s2 = CreateASTNode(IFTHEN1);
                $$->s2->s1 = $6;
                $$->s2->s2 = NULL;
                
    
} // of if then
        |       IF '(' expression ')' THEN  statement ELSE statement{
            
                $$ = CreateASTNode(IFTHEN);
                $$->s1 = $3;
                $$->s2 = CreateASTNode(IFTHEN1);
                $$->s2->s1 = $6;
                $$->s2->s2 = $8;
            
            
        }// of if then else
        ;

iterationstmt : WHILE  expression DO statement{
                
                $$ = CreateASTNode(myWHILE);
                $$->s1 = $2;
                $$->s2 = $4;
                
} // of while
    ;
    
returnstmt : MYRETURN expression ';'{
                $$ = CreateASTNode(RET);
                $$->s1 = $2;
                $$->value = 1;
}// of return expr
    |    MYRETURN ';' {$$ = CreateASTNode(RET);}
        ;
        
readstmt : READ var ';'
            {$$ = CreateASTNode(myREAD);
             $$->s1 = $2;
            }// of read
    ;
writestmt : WRITE expression ';'
        {$$ = CreateASTNode(myWRITE);
         $$->s1 = $2;
        } // of writestmt
    | WRITE STRING ';'{
        $$ = CreateASTNode(myWRITE);
        $$->name = $2;
        $$->label = genlabel();
        printf("found a write string with %s\n", $2);
        
    }
    ;
    
assignmentstmt : var '=' simpleExpr ';'{ 
    
            //make sure both types in assignment statement are the same
            if($1->semanticType != $3->semanticType){
                yyerror("type mismatch on assignment");
                exit(1);
            }
    
            $$ = CreateASTNode(ASSGINSTMT);
            $$->name = CreateTemp();
         $$->symbol = Insert($$->name, INT, 0, level, 1, offset, NULL);
         offset++;
            $$->s1 = $1;
            $$->s2 = $3;
    
} // of var = simpleexpr
    ;
expression : simpleExpr {$$ = $1;}
    ;
  /*is a func 
    0 = scalar
    1 = function
    2 = array 
    */
var : ID {
        
        struct SymbTab *s;
        s = Search($1, level, 1);   //get symbol of current ID
        if(s == NULL){   //check if doesnt exsist
            yyerror($1);
            yyerror("Varible not found");
            exit(1);
        }// if var does not exist
    
        if (s->IsAFunc != 0){     //check if a function name
            yyerror($1);
            yyerror("must be a scalar to use here");
            exit(1);
        }// if not a scalar
    
       
    
        $$ = CreateASTNode(VAR);
        $$->name = $1;
         $$->semanticType = s->Type;
         $$->value = 0;
        $$->symbol = Search($1, level, 1);
} // of id
    | ID '[' expression ']'{
        
        struct SymbTab *s;
        s = Search($1, level, 1);  //get symbol of current ID
        if(s == NULL){    //check to see if exsists
            yyerror($1);
            yyerror("Varible not found");
            exit(1);
        }// if var does not exist
    
        if (s->IsAFunc != 2){      //check that is an array
            yyerror($1);
            yyerror("must be an array to use here");
            exit(1);
        }// if not a scalar
        
        
        
        
        $$ = CreateASTNode(VAR);
        $$->name = $1;
        $$->s1 = $3;
        //$$->symbol = s; // stroe the pointer to symbol
        $$->value = -1;
         $$->semanticType = s->Type;
         $$->symbol = Search($1, level, 1);
    } // of id expr
        
    ;
    
simpleExpr : addExpr {$$ = $1;}
    |        addExpr relop addExpr {
        //make sure types are similar in an simple expression
          if ($1->semanticType != $3->semanticType){
              yyerror("type mismatch");
              exit(1);
          }// if not matching types
          $$ = CreateASTNode(EXPR);
         $$->name = CreateTemp();
         $$->symbol = Insert($$->name, INT, 0, level, 1, offset, NULL);
         offset++;
          $$-> s1 = $1;
          $$-> s2 = $3;
          $$->operator = $2;
          $$->semanticType = $1->semanticType;  //set type of expression to the type of the first token
    } // of simpleExpr relop addExpr
    ;
    
relop : LE {$$ = myLE;}| '<' {$$ = LT;} | '>' {$$ = GT;}| GE {$$ = myGE;} | EE {$$ = myEE;}| NE {$$ = myNE;}
    ;
    
addExpr : term {$$ = $1;}
    |     addExpr addop term {
        
         //make sure types are similar in an add expression
         
          if ($1->semanticType != $3->semanticType){
              yyerror("type mismatch");
              exit(1);
          }// if not matching types
        
          $$ = CreateASTNode(EXPR);
        $$->name = CreateTemp();
         $$->symbol = Insert($$->name, INT, 0, level, 1, offset, NULL);
         offset++;
          $$-> s1 = $1;
          $$-> s2 = $3;
          $$->operator = $2;
          $$->semanticType = $1->semanticType; //set type of expression to the type of the first token
    } // of addExpr addop term
    ;

addop : '+' {$$ = PLUS;}
    | '-'  {$$ = MINUS;}  
    ;
    
term : factor {$$ = $1;}
    |  term multop factor {
        
        //make sure types are similar in an multop expression
          if ($1->semanticType != $3->semanticType){
              yyerror("type mismatch");
              exit(1);
          }// if not matching types
        
        $$ = CreateASTNode(EXPR);
        $$->name = CreateTemp();
         $$->symbol = Insert($$->name, INT, 0, level, 1, offset, NULL);
         offset++;
        $$ -> s1 = $1;
        $$ -> s2 = $3;
        $$ -> operator = $2;
          $$->semanticType = $1->semanticType; //set type of expression to the type of the first token
        
    
    } // of term multop factor
    ;
    
multop : '*' {$$ = MULT;}
    | '/'    {$$ = DIV;}
    | AND    {$$ = MYAND;
    }
    | OR     {$$ = MYOR;
    }
    ;
    
factor : '(' expression ')' {$$ = $2;}
    | NUM { $$ = CreateASTNode(myNUM);
            $$->value = $1;
            $$->semanticType = INTTYPE;  //type for all nums is int
          } 
    | var {$$ = $1;}
    | call {$$ = $1;}
    | TRUE {$$ = CreateASTNode(myNUM);
            $$->value = 1;
            $$->semanticType = BOOLTYPE;  // type for true is bool
           }
    | FALSE {$$ = CreateASTNode(myNUM);
            $$->value = 0;
            $$->semanticType = BOOLTYPE;   //type for false is bool
            }
    | NOT factor {
        //check if ok
                /*if($2->semanticType != BOOLTYPE){
                    yyerror("not needs a boolean type." );
                    exit(1);
                }// if not boolean 
        */
        
                 $$ = CreateASTNode(EXPR);
                $$->name = CreateTemp();
                $$->symbol = Insert($$->name, INT, 0, level, 1, offset, NULL);
              
                offset++;
                 $$->s1 = $2;
                 $$->operator = MYNOT;
                 $$->semanticType = $2->semanticType;
                 }
    ;
    
call : ID '(' args ')' { 
    
    
         struct SymbTab *s;
        s = Search($1, level, 1);
        if(s == NULL){     //check that s exsists
            yyerror($1);
            yyerror("Function name not found");
            exit(1);
        }// if var does not exist
    
        if (s->IsAFunc != 1){   //make sure it is a function
            yyerror($1);
            yyerror("must be a fuction to use here");
            exit(1);
        }// if not a func
    
    //check the formal parameters vs actual
    if(checkFormalsAndparams(s->fparms, $3) != 1){
        yyerror("function paramter mismatch");
        exit(1);
    }
    
       $$ = CreateASTNode(FUNCCALL);
       $$->name = $1;
       $$->s1 = $3;
       $$->symbol = s;
       $$->semanticType = s->Type; //from symbol table
} // of id args
     ;
    
args : arglist {$$ = $1;}
    |          {$$ = NULL;}
    ;
    
arglist : expression {$$ = CreateASTNode(ARGS);
                      $$->name = CreateTemp();
                        $$->symbol = Insert($$->name, INT, 0, level, 1, offset, NULL);
                        offset++;
                      $$->s1 = $1;
                      $$->value = 0;
                      $$->semanticType = $1->semanticType;
                      $$->next = NULL;
                     }
    |     expression ',' arglist{ $$ = CreateASTNode(ARGS);
                                 $$->name = CreateTemp();
                                 $$->symbol = Insert($$->name, INT, 0, level, 1, offset, NULL);
                                offset++;
                                $$->s1 =$1;
                                $$->value = 1;
                                $$->semanticType = $1->semanticType;
                                $$->next = $3;
                                }
    ;
    
    
    
    
%%	/* end of rules, start of program */

int main(int argc, char * argv[])
{ yyparse();
 
 
 printf("main symbol start");
 Display();
 printf("main symbol end\n");
ASTprint(GlobalTreePointer, 0);

 int i = 1;
char s[100];
FILE *fp;
int foundit =0;

while(i < argc){

	if(strcmp(argv[i], "-d") == 0){

		mydebug = 1;
        
    		i = i + 1;
	}// if
	else if (strcmp(argv[i], "-o") == 0){
		if(argc > i + 1) foundit= 1;
		sprintf(s, "%s.asm", argv[i+1]);
   		 i = i+2;
	}// else if
	else i = i + 1;

}// pf while

//now we want to open a file descriptor and use that var to write our open file
	if(foundit == 0){
		printf("-o argument is needed");
		exit(1);
		}
	fp = fopen(s, "w");
	if(fp == NULL){

	printf("can not open file %s \n", s);
	exit(1);
	}// if not found

	fprintf(fp, "#Hello world\n");

    fprintf(fp,".data\n\n");
    EmitStrings(GlobalTreePointer, fp);
   fprintf(fp, "\n.align 2\n\n");
   EMITGLOBALS(GlobalTreePointer, fp);
   fprintf(fp,"\n.text\n\n");
 
    EMITAST(GlobalTreePointer, fp);
 
    
}



