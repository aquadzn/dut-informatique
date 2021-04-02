    l1 = strlen(str);
 
    printf("\nEnter a substring : ");
    scanf(" %[^\n]s", sub);
 
    l2 = strlen(sub);
 
    for (i = 0; i < l1;)
    {
        j = 0;
        count = 0;
        while ((str[i] == sub[j]))
        {
            count++;
            i++;
            j++;
        }
        if (count == l2)
        {
            count1++;                                   
            count = 0;
        }
        else
            i++;
    }    
