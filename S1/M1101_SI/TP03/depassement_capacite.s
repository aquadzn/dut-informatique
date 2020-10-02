        .text
        .globl main
main:
        movb $127, %al
        movb $4, %bl
        addb %bl, %al
        ret

