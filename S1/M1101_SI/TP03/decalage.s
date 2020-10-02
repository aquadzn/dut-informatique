        .text
        .globl main
main:
        movb $1, %al
        rolb $1, %al
        rolb $1, %al
        rolb $1, %al
        ret

