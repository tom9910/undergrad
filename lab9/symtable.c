/* 
//Thomas Sanchez
//lab9.c 
//05-08-20
// lab9 changes: PRODUCE MIPS CODE add strings
*/

    
#include <string.h>
#include "symtable.h"
#include <stdlib.h>
#include <stdio.h>


struct SymbTab * first = NULL;

static int GTEMP = 0;


/* Simple Insert into the symbol table with the size, type level that the name is being inserted into */

struct SymbTab * Insert(char *name, enum OPERATORS Type, int isafunc, int  level, int mysize, int offset , ASTNode * fparms)

{
  struct SymbTab * n;
    n=Search(name,level, 0);
    if(n!=NULL)
      {
      printf("\n\tThe name %s exists at level %d already in the symbol table\n\tDuplicate can.t be inserted",name, level);
      return (NULL);
      }
    else
    {
      struct SymbTab *p;
      p=malloc(sizeof(struct SymbTab));
      p->name=name;
      p->offset=offset;  /* assign the offset */
      p->level=level;  /* assign the level */
      p->mysize=mysize;  /* assign the size */
      p->Type=Type;  /* assign the Type */
     // p->semanticType = semanticType;
      p->IsAFunc=isafunc;  /* assign the Function  */
      p->fparms=fparms;  /* assign the Function  */
      p->next=NULL;

   /* Check on how many elements we have in the symbol table */
      if(first==NULL)
      {
        first=p;
      }
      else
      {
        p->next=first;
        first=p;
      }
      return (p);
 
    }
     
  printf("\n\tLabel inserted\n");
}

/* print out a single symbol table entry -- for debugging */
void PrintSym(struct SymbTab *s)
{
         printf("\t%s\t\t%d\t\t%d\n",s->name,s->offset, s->level);

}

char* CreateTemp(){
    char hold[100];
    char * s;
    sprintf(hold, "_t%d", GTEMP++);
    s=strdup(hold);
    return(s);
}

/*  General display to see what is our symbol table */

void Display()
{
   int i;
   struct SymbTab *p;
   p=first;
   printf("\n\tLABEL\t\tOffset \t LEVEL\n");
      while (p!=NULL)
      {
         PrintSym(p);
         p=p->next;
      }
}

/*  Search for a symbol name at level or below.  We have to do multiple passes into the symbol table because we have to find
   the name closest to us 


  If recur is non-zero, then we look through all of the levels, otherwise, only our level 
   We return a pointer to a SymbolTab structure so that we can use other functions/methods to get the attributes */

 


struct SymbTab * Search(char name[], int level, int recur)
{
   int i,flag=0;
   struct SymbTab *p;

  /* for each level, try to find our symbol */
   while (level >= 0)
    {
       p=first;
       while (p!=NULL)
        {
         if((strcmp(p->name,name)==0) && (p->level == level))
           return p;
         p=p->next;
        }
       if (recur == 0) return (NULL);   /* we did not find it at our level */
       level--; /* check the next level up */
    }


   return  NULL;  /* did not find it, return 0 */
}

/* Remove all enteries that have the indicated level
   We need to take care about updating first pointer into the linked list when we are deleting edge elements */


int Delete(int level)
{
    struct SymbTab *p,*f=NULL;  /* we follow with pointer f */
    int SIZE=0;
    p=first;

    
    
  /* cruise through the list */

    while (p != NULL)
      {
        /* do we match? */
        if (p->level>= level )
        { /* if it is the first in the list we have to update first, we know this by f being NULL */
           SIZE+=p->mysize;
           if ( f==NULL) first=p->next;
           else /* not the first element */
              {f->next=p->next;
              }
            p=p->next;
           
        }
        else
         {
               /* update follow pointer, move the p pointer */
                f=p;
                p=p->next;
          }

      }
    return(SIZE);
}

