/*                 Thomas Sanchez
		   05-8-20
		   lab9 version
		
*/
%{

int mydebug=0;
int linecount =1;

#include "ast.h"
#include "y.tab.h"
%}


%%
	/*keywords before other definition */
int		{return(INT);}	/*key word int (must go before variable) */
void {return(VOID);}
and {return(AND);}
or {return(OR);}
not {return(NOT);}
while {return(WHILE);}
do {return(DO);}
if {return(IF);}
else {return(ELSE);}
read {return(READ);}
write {return(WRITE);}
begin {return(MYBEGIN);}
end {return(END);}
id {return(ID);}
then {return(THEN);}
return {return(MYRETURN);}
true {return(TRUE);}
false {return(FALSE);}
boolean {return(BOOLEAN);}
"<=" {return(LE);}
">=" {return(GE);}
"==" {return(EE);}
"!=" {return(NE);}
\".*\" {yylval.string = strdup(yytext); return(STRING);}



[a-zA-Z][a-zA-Z0-9]*		{if (mydebug) fprintf(stderr,"id found\n"); /*varibles can be letters and nums*/
                       yylval.string = strdup(yytext); return(ID);}	//strdup so yacc has a copy

[0-9][0-9]*	{if (mydebug) fprintf(stderr,"Digit found\n"); 
                       yylval.number=atoi((const char *)yytext); return(NUM);}
                       
[ \t]		{if (mydebug) fprintf(stderr,"Whitespace found\n");}
[\[\]=\-+*/%|();,<>] 	{ if (mydebug) fprintf(stderr,"return a token %c\n",*yytext); /*included (), [\] \ <> and ; */
                       return (*yytext);}
\n 		{ if (mydebug) fprintf(stderr,"cariage return %c\n",*yytext);
                       linecount++; /*line count included */
                       }
		
%%

int yywrap(void)
{ return 1;}


