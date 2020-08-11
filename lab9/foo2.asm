#Hello world
.data

_L2:	 .asciiz	"A["
_L3:	 .asciiz	"] = "
_L4:	 .asciiz	"\n"
_L1:	 .asciiz	"\n"
_L0:	 .asciiz	"enter X: "

.align 2

A:	 .space	400

.text

main:		#start of function
	
	subu $a0, $sp, 64 
	sw $sp, ($a0) 
	sw $ra, 4($a0) 
	move $sp, $a0		#adjust stack pointer

			
	add $a0, $sp, 20		#identifier is a local scalar


	sw $a0, 28($sp)		
	li $a0, 0		# expression is a number
	lw $t0, 28($sp)		
	sw $a0, ($t0)		
_L5:		#loop start
	add $a0, $sp, 20		#identifier is a local scalar


	lw $a0, ($a0)		#fetch value
	sw $a0 32($sp)		# store into offset
	li $a0, 5		# expression is a number
	move $a1, $a0		
	lw $a0 32($sp)		#load a0
	slt $a0, $a0, $a1		#set less than
	li $t1, 0		
	beq $a0, $t1, _L6		#if not true
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
	j _L5
_L6:nop		#end of if section

			
	add $a0, $sp, 20		#identifier is a local scalar


	sw $a0, 36($sp)		
	li $a0, 0		# expression is a number
	lw $t0, 36($sp)		
	sw $a0, ($t0)		
_L7:		#loop start
	add $a0, $sp, 20		#identifier is a local scalar


	lw $a0, ($a0)		#fetch value
	sw $a0 40($sp)		# store into offset
	li $a0, 5		# expression is a number
	move $a1, $a0		
	lw $a0 40($sp)		#load a0
	slt $a0, $a0, $a1		#set less than
	li $t1, 0		
	beq $a0, $t1, _L8		#if not true
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
	mult $a0 $a1		#expr mult
	mflo $a0		#expr mult
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
	j _L7
_L8:nop		#end of if section

			
	add $a0, $sp, 24		#identifier is a local scalar


	sw $a0, 44($sp)		
	li $a0, 10		# expression is a number
	lw $t0, 44($sp)		
	sw $a0, ($t0)		
_L9:		#loop start
	add $a0, $sp, 24		#identifier is a local scalar


	lw $a0, ($a0)		#fetch value
	sw $a0 48($sp)		# store into offset
	li $a0, 0		# expression is a number
	move $a1, $a0		
	lw $a0 48($sp)		#load a0
	sge $a0, $a0, $a1		#set greater o reqaul to
	li $t1, 0		
	beq $a0, $t1, _L10		#if not true
			
	la $t0, A		#global array
	add $a0, $sp, 24		#identifier is a local scalar


	lw $a0, ($a0)		#fetch value
	sll $a0, $a0, 8		
	add $a0, $a0, $t0		
	sw $a0, 52($sp)		
	add $a0, $sp, 24		#identifier is a local scalar


	lw $a0, ($a0)		#fetch value
	lw $t0, 52($sp)		
	sw $a0, ($t0)		
	li $v0, 4		
	la $a0, _L2		
	syscall		
			
	add $a0, $sp, 24		#identifier is a local scalar


	lw $a0, ($a0)		#fetch value
	li $v0 1		# Print the number
	syscall		# system call

	li $v0, 4		
	la $a0, _L3		
	syscall		
			
	la $t0, A		#global array
	add $a0, $sp, 24		#identifier is a local scalar


	lw $a0, ($a0)		#fetch value
	sll $a0, $a0, 8		
	add $a0, $a0, $t0		
	lw $a0, ($a0)		#fetch value
	li $v0 1		# Print the number
	syscall		# system call

	li $v0, 4		
	la $a0, _L4		
	syscall		
			
			
	add $a0, $sp, 24		#identifier is a local scalar


	sw $a0, 60($sp)		
	add $a0, $sp, 24		#identifier is a local scalar


	lw $a0, ($a0)		#fetch value
	sw $a0 56($sp)		# store into offset
	li $a0, 1		# expression is a number
	move $a1, $a0		
	lw $a0 56($sp)		#load a0
	sub $a0, $a0, $a1		#expr sub
	lw $t0, 60($sp)		
	sw $a0, ($t0)		
	j _L9
_L10:nop		#end of if section

	lw $ra, 4($sp)		#restore RA
	lw $sp, ($sp)		#restore SP

	li $v0, 10		 #leave Main program
	syscall		#leave main
	sw $v0 ($a0)		#store the REad into a mem location
