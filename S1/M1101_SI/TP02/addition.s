    .data
var1:   .long 1
var2:   .long 2
        .text
        .globl main
main:
        movl var1, %eax
        movl var2, %ebx
        addl %ebx, %eax
        ret
