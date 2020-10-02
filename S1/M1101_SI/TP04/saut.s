        .data
vara:   .long   10
varb:   .long   11
varc:   .long   12
vard:   .long   13
        .text
        .globl main
main:
        jmp vars

val:    movl $1, %eax
        movl $2, %ebx
        movl $3, %ecx
        movl $4, %edx
        jmp fin

vars:   movl vara, %eax
        movl varb, %ebx
        movl varc, %ecx
        movl vard, %edx
        jmp reg

ref:    movl $vara, %eax
        movl $varb, %ebx
        movl $varc, %ecx
        movl $vard, %edx
        jmp val

reg:    movl %eax, vara
        movl %ebx, varb
        movl %ecx, varc
        movl %edx, vard
        jmp ref

fin:    ret
