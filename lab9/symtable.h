//Thomas Sanchez
//lab9.c 
//05-08-20
// lab9 changes: PRODUCE MIPS CODE add strings


    

#include "ast.h"

#ifndef _SYMTAB 
#define _SYMTAB


void Display();
int Delete();

int FetchAddr (char *lab);

struct SymbTab
{
     char *name;
     int offset; /* from activation record boundary */
     int mysize;  /* number of words this item is 1 or more */
     int level;  /* the level where we found the variable */
     enum OPERATORS Type;  /* the type of the symbol */
     enum OPERATORS semanticType; /*the type */
     int IsAFunc;  /* the element is a function */
     ASTNode * fparms; /* pointer to parameters of the function in the AST */

     struct SymbTab *next;
};


struct SymbTab * Insert(char *name, enum OPERATORS Type, int isafunc, int  level, int mysize, int offset, ASTNode * fparms );
struct SymbTab * Search(char name[], int level, int recur);
char* CreateTemp();
#endif
