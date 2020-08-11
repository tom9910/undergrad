#Hello world
.data


.align 2

x:	 .space	4

.text

main:		#start of function
	
	subu $a0, $sp, 20 
	sw $sp, ($a0) 
	sw $ra, 4($a0) 
	move $sp, $a0		#adjust stack pointer

			
	add $a0, $sp, 8		#identifier is a local scalar


	sw $a0, 16($sp)		
	li $a0, 1		# expression is a number
	sw $a0 12($sp)		# store into offset
	li $a0, 2		# expression is a number
	move $a1, $a0		
	lw $a0 12($sp)		#load a0
	add $a0, $a0, $a1		#expr ADD
	lw $t0, 16($sp)		
	sw $a0, ($t0)		
	lw $ra, 4($sp)		#restore RA
	lw $sp, ($sp)		#restore SP

	li $v0, 10		 #leave Main program
	syscall		#leave main
	sw $v0 ($a0)		#store the REad into a mem location
