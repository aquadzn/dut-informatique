	.data
var1:
	.byte 65
	.text
	.globl main
main:
	movl $4, %eax
	movl $1, %ebx
	movl $var1, %ecx
	movl $1, %edx
	int $0x80
    ret
