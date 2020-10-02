        .data
        .text
        .globl main
main:
        movl $7, %eax
        movl $2, %ebx
        movl $0, %edx
        mull %ebx
        ret
