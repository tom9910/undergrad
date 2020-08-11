//Thomas Sanchez
//lab9
//05-08-20
// lab9 changes: PRODUCE MIPS CODE add strings
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#ifndef EMIT_H
#define EMIT_H

#include "ast.h"
#include "symtable.h"
#define WSIZE 4  // number of bytes in a word
#define LOGWSIZE 2  // number of shifts to get to WSIZE


char * genlabel();



void EMITAST(ASTNode * p, FILE * fp);
void EmitStrings(ASTNode * p, FILE * fp);
void EMITGLOBALS(ASTNode * p, FILE * fp);
void emit_expr(ASTNode * p, FILE * fp);
void emit_assignment(ASTNode * p, FILE * fp);
#endif  // of EMIT.h
