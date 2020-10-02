        .data
vara:   .long   5
varb:   .long   9
        .text
        .globl main
main:
        jmp comp

sous:   movl varb, %eax
        subl %ebx, %eax
        jz fin

comp:   movl vara, %eax
        movl varb, %ebx
        cmpl %eax, %ebx
        jg sous

fin:    ret
