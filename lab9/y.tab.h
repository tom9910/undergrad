/* A Bison parser, made by GNU Bison 2.3.  */

/* Skeleton interface for Bison's Yacc-like parsers in C

   Copyright (C) 1984, 1989, 1990, 2000, 2001, 2002, 2003, 2004, 2005, 2006
   Free Software Foundation, Inc.

   This program is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation; either version 2, or (at your option)
   any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program; if not, write to the Free Software
   Foundation, Inc., 51 Franklin Street, Fifth Floor,
   Boston, MA 02110-1301, USA.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* Tokens.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
   /* Put the tokens into the symbol table, so that GDB and other debuggers
      know about them.  */
   enum yytokentype {
     NUM = 258,
     ID = 259,
     STRING = 260,
     INT = 261,
     AND = 262,
     OR = 263,
     NOT = 264,
     VOID = 265,
     WHILE = 266,
     DO = 267,
     IF = 268,
     ELSE = 269,
     READ = 270,
     WRITE = 271,
     MYBEGIN = 272,
     THEN = 273,
     MYRETURN = 274,
     TRUE = 275,
     FALSE = 276,
     BOOLEAN = 277,
     END = 278,
     FOR = 279,
     LE = 280,
     GE = 281,
     EE = 282,
     NE = 283
   };
#endif
/* Tokens.  */
#define NUM 258
#define ID 259
#define STRING 260
#define INT 261
#define AND 262
#define OR 263
#define NOT 264
#define VOID 265
#define WHILE 266
#define DO 267
#define IF 268
#define ELSE 269
#define READ 270
#define WRITE 271
#define MYBEGIN 272
#define THEN 273
#define MYRETURN 274
#define TRUE 275
#define FALSE 276
#define BOOLEAN 277
#define END 278
#define FOR 279
#define LE 280
#define GE 281
#define EE 282
#define NE 283




#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
typedef union YYSTYPE
#line 59 "lab9.y"
{					//so yacc can recieve integer and string type from lex
    int number;
    char * string;
   
    struct ASTNodeType * node;
    enum OPERATORS operator;
}
/* Line 1529 of yacc.c.  */
#line 113 "y.tab.h"
	YYSTYPE;
# define yystype YYSTYPE /* obsolescent; will be withdrawn */
# define YYSTYPE_IS_DECLARED 1
# define YYSTYPE_IS_TRIVIAL 1
#endif

extern YYSTYPE yylval;

