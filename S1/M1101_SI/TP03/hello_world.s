        .data
hello:  .ascii "Vivement le week-end !\n"
taille: .long 23
        .text
        .globl main
main:
        movl $4, %eax
        movl $1, %ebx
        movl $hello, %ecx
        movl taille, %edx
        int $0x80
        ret

