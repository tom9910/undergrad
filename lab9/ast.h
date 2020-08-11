//
////Thomas Sanchez
//lab9.c 
//05-08-20
// lab9 changes: PRODUCE MIPS CODE add strings
//
//
#ifndef AST
#define AST

enum NODETYPE{
    VARDEC,
    VAR,
    FUNDEC,
    CMPSTMT,
    PARAM,
    myWRITE,
    myREAD,
    myNUM,
    EXPR,
    myWHILE,
    ASSGINSTMT,
    EXPRSTMT,
    IFTHEN,
    IFTHEN1,
    FUNCCALL,
    ARGS,
    RET,
    FORLOOP,
    FORLOOP1,
    FORLOOP2
    
    
};   // of enum NODETYPE

enum OPERATORS{
    INTTYPE,
    VOIDTYPE,
    BOOLTYPE,
    
    PLUS,
    MINUS,
    MULT,
    DIV,
    MYAND,
    MYOR,
    MYNOT,
    
    myLE,
    myGE,
    myEE,
    myNE,
    GT,
    LT
};

typedef struct ASTNodeType
{
    enum OPERATORS operator;
    enum NODETYPE Type;
    enum OPERATORS semanticType;
    char * name;
    char * label;
   
    int value;
    
    struct ASTNodeType *s1, *s2, *next;
    struct SymbTab *symbol;
    
    

    
}ASTNode;


void ASTprint(ASTNode *p, int level);

int checkFormalsAndparams(ASTNode *f, ASTNode *a);

ASTNode * CreateASTNode(enum NODETYPE DesiredType);

void PT(int num);


#endif

