#Hello world
.data

_L2:	 .asciiz	"guess a number between 1-5: "
_L4:	 .asciiz	"not false = "
_L5:	 .asciiz	"\n"
_L6:	 .asciiz	"\n"
_L7:	 .asciiz	"\n"
_L8:	 .asciiz	"\n"
_L3:	 .asciiz	"guess again "
_L1:	 .asciiz	"\n"
_L0:	 .asciiz	"enter X: "

.align 2

A:	 .space	400
b:	 .space	80
global:	 .space	4

.text

main:		#start of function
	
	subu $a0, $sp, 92 
	sw $sp, ($a0) 
	sw $ra, 4($a0) 
	move $sp, $a0		#adjust stack pointer

			
	add $a0, $sp, 20		#identifier is a local scalar


	sw $a0, 28($sp)		
	li $a0, 0		# expression is a number
	lw $t0, 28($sp)		
	sw $a0, ($t0)		
_L9:		#loop start
	add $a0, $sp, 20		#identifier is a local scalar


	lw $a0, ($a0)		#fetch value
	sw $a0 32($sp)		# store into offset
	li $a0, 5		# expression is a number
	move $a1, $a0		
	lw $a0 32($sp)		#load a0
	slt $a0, $a0, $a1		#set less than
	li $t1, 0		
	beq $a0, $t1, _L10		#if not true
	li $v0, 4		
	la $a0, _L0		
	syscall		
			
	add $a0, $sp, 20		#identifier is a local scalar


	lw $a0, ($a0)		#fetch value
	sll $a0, $a0, 8		
	add $a0, $a0, 8		
	add $a0, $a0, $sp		
	li $v0, 5		#read num from input
	syscall		# system call


	sw $v0, ($a0)		#store the read into a mem location


			
	add $a0, $sp, 20		#identifier is a local scalar


	sw $a0, 40($sp)		
	add $a0, $sp, 20		#identifier is a local scalar


	lw $a0, ($a0)		#fetch value
	sw $a0 36($sp)		# store into offset
	li $a0, 1		# expression is a number
	move $a1, $a0		
	lw $a0 36($sp)		#load a0
	add $a0, $a0, $a1		#expr ADD
	lw $t0, 40($sp)		
	sw $a0, ($t0)		
	j _L9
_L10:nop		#end of if section

			
	add $a0, $sp, 20		#identifier is a local scalar


	sw $a0, 36($sp)		
	li $a0, 0		# expression is a number
	lw $t0, 36($sp)		
	sw $a0, ($t0)		
_L11:		#loop start
	add $a0, $sp, 20		#identifier is a local scalar


	lw $a0, ($a0)		#fetch value
	sw $a0 40($sp)		# store into offset
	li $a0, 5		# expression is a number
	move $a1, $a0		
	lw $a0 40($sp)		#load a0
	slt $a0, $a0, $a1		#set less than
	li $t1, 0		
	beq $a0, $t1, _L12		#if not true
	add $a0, $sp, 20		#identifier is a local scalar


	lw $a0, ($a0)		#fetch value
	sll $a0, $a0, 8		
	add $a0, $a0, 8		
	add $a0, $a0, $sp		
	lw $a0, ($a0)		#fetch value
	sw $a0 44($sp)		# store into offset
	add $a0, $sp, 20		#identifier is a local scalar


	lw $a0, ($a0)		#fetch value
	sll $a0, $a0, 8		
	add $a0, $a0, 8		
	add $a0, $a0, $sp		
	lw $a0, ($a0)		#fetch value
	move $a1, $a0		
	lw $a0 44($sp)		#load a0
	add $a0, $a0, $a1		#expr ADD
	li $v0 1		# Print the number
	syscall		# system call

	li $v0, 4		
	la $a0, _L1		
	syscall		
			
			
	add $a0, $sp, 20		#identifier is a local scalar


	sw $a0, 52($sp)		
	add $a0, $sp, 20		#identifier is a local scalar


	lw $a0, ($a0)		#fetch value
	sw $a0 48($sp)		# store into offset
	li $a0, 1		# expression is a number
	move $a1, $a0		
	lw $a0 48($sp)		#load a0
	add $a0, $a0, $a1		#expr ADD
	lw $t0, 52($sp)		
	sw $a0, ($t0)		
	j _L11
_L12:nop		#end of if section

			
	add $a0, $sp, 24		#identifier is a local scalar


	sw $a0, 44($sp)		
	li $a0, 0		# expression is a number
	lw $t0, 44($sp)		
	sw $a0, ($t0)		
	li $v0, 4		
	la $a0, _L2		
	syscall		
			
	add $a0, $sp, 24		#identifier is a local scalar


	li $v0, 5		#read num from input
	syscall		# system call


	sw $v0, ($a0)		#store the read into a mem location


_L13:		#loop start
	add $a0, $sp, 24		#identifier is a local scalar


	lw $a0, ($a0)		#fetch value
	sw $a0 48($sp)		# store into offset
	li $a0, 2		# expression is a number
	move $a1, $a0		
	lw $a0 48($sp)		#load a0
	sne $a0, $a0, $a1		#set  not eqaul to
	li $t1, 0		
	beq $a0, $t1, _L14		#if not true
	li $v0, 4		
	la $a0, _L3		
	syscall		
			
	add $a0, $sp, 24		#identifier is a local scalar


	li $v0, 5		#read num from input
	syscall		# system call


	sw $v0, ($a0)		#store the read into a mem location


	j _L13
_L14:nop		#end of if section

	li $v0, 4		
	la $a0, _L4		
	syscall		
			
	li $a0, 0		# expression is a number
	sw $a0 52($sp)		# store into offset
	lw $a0 52($sp)		#load a0
	sltiu $a0, $a0 1		#not comparison
	li $v0 1		# Print the number
	syscall		# system call

	li $v0, 4		
	la $a0, _L5		
	syscall		
			
	li $a0, 3		# expression is a number
	sw $a0 56($sp)		# store into offset
	li $a0, 7		# expression is a number
	move $a1, $a0		
	lw $a0 56($sp)		#load a0
	mult $a0 $a1		#expr mult
	mflo $a0		#expr mult
	sw $a0 60($sp)		# store into offset
	li $a0, 1		# expression is a number
	move $a1, $a0		
	lw $a0 60($sp)		#load a0
	sgt $a0, $a0, $a1		#set greater than
	sw $a0 68($sp)		# store into offset
	li $a0, 1		# expression is a number
	sw $a0 64($sp)		# store into offset
	li $a0, 1		# expression is a number
	move $a1, $a0		
	lw $a0 64($sp)		#load a0
	seq $a0, $a0, $a1		#set eqaul to 
	move $a1, $a0		
	lw $a0 68($sp)		#load a0
	and $a0, $a0, $a1		# and
	li $t0, 0		
	beq $a0, $t0, _L15		#if not true
			
	la $t0, A		#global array
	li $a0, 0		# expression is a number
	sll $a0, $a0, 8		
	add $a0, $a0, $t0		
	sw $a0, 72($sp)		
	li $a0, 43		# expression is a number
	lw $t0, 72($sp)		
	sw $a0, ($t0)		
			
	la $t0, A		#global array
	li $a0, 1		# expression is a number
	sll $a0, $a0, 8		
	add $a0, $a0, $t0		
	sw $a0, 76($sp)		
	li $a0, 11		# expression is a number
	lw $t0, 76($sp)		
	sw $a0, ($t0)		
			
	la $t0, A		#global array
	li $a0, 99		# expression is a number
	sll $a0, $a0, 8		
	add $a0, $a0, $t0		
	sw $a0, 80($sp)		
	li $a0, 0		# expression is a number
	lw $t0, 80($sp)		
	sw $a0, ($t0)		
	la $t0, A		#global array
	li $a0, 0		# expression is a number
	sll $a0, $a0, 8		
	add $a0, $a0, $t0		
	lw $a0, ($a0)		#fetch value
	li $v0 1		# Print the number
	syscall		# system call

	la $t0, A		#global array
	li $a0, 1		# expression is a number
	sll $a0, $a0, 8		
	add $a0, $a0, $t0		
	lw $a0, ($a0)		#fetch value
	li $v0 1		# Print the number
	syscall		# system call

	la $t0, A		#global array
	li $a0, 99		# expression is a number
	sll $a0, $a0, 8		
	add $a0, $a0, $t0		
	lw $a0, ($a0)		#fetch value
	li $v0 1		# Print the number
	syscall		# system call

	j _L16
_L15:		#else section
_L16:nop		#end of if section

	li $v0, 4		
	la $a0, _L6		
	syscall		
			
	li $a0, 1		# expression is a number
	sw $a0 72($sp)		# store into offset
	li $a0, 100		# expression is a number
	move $a1, $a0		
	lw $a0 72($sp)		#load a0
	slt $a0, $a0, $a1		#set less than
	sw $a0 80($sp)		# store into offset
	li $a0, 5		# expression is a number
	sw $a0 76($sp)		# store into offset
	li $a0, 5		# expression is a number
	move $a1, $a0		
	lw $a0 76($sp)		#load a0
	sne $a0, $a0, $a1		#set  not eqaul to
	move $a1, $a0		
	lw $a0 80($sp)		#load a0
	or $a0, $a0, $a1		#or
	li $v0 1		# Print the number
	syscall		# system call

	li $v0, 4		
	la $a0, _L7		
	syscall		
			
			
	la $t0, b		#global array
	la $t0, A		#global array
	li $a0, 1		# expression is a number
	sll $a0, $a0, 8		
	add $a0, $a0, $t0		
	lw $a0, ($a0)		#fetch value
	sll $a0, $a0, 8		
	add $a0, $a0, $t0		
	sw $a0, 84($sp)		
	li $a0, 5		# expression is a number
	lw $t0, 84($sp)		
	sw $a0, ($t0)		
	la $t0, b		#global array
	la $t0, A		#global array
	li $a0, 1		# expression is a number
	sll $a0, $a0, 8		
	add $a0, $a0, $t0		
	lw $a0, ($a0)		#fetch value
	sll $a0, $a0, 8		
	add $a0, $a0, $t0		
	lw $a0, ($a0)		#fetch value
	li $v0 1		# Print the number
	syscall		# system call

			
	la $a0, global		#global indentifier
	sw $a0, 88($sp)		
	la $t0, b		#global array
	la $t0, A		#global array
	li $a0, 1		# expression is a number
	sll $a0, $a0, 8		
	add $a0, $a0, $t0		
	lw $a0, ($a0)		#fetch value
	sll $a0, $a0, 8		
	add $a0, $a0, $t0		
	lw $a0, ($a0)		#fetch value
	lw $t0, 88($sp)		
	sw $a0, ($t0)		
	li $v0, 4		
	la $a0, _L8		
	syscall		
			
	la $a0, global		#global indentifier
	lw $a0, ($a0)		#fetch value
	li $v0 1		# Print the number
	syscall		# system call

	lw $ra, 4($sp)		#restore RA
	lw $sp, ($sp)		#restore SP

	li $v0, 10		 #leave Main program
	syscall		#leave main
	sw $v0 ($a0)		#store the REad into a mem location
