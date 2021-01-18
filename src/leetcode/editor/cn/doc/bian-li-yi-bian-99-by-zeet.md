
观察官方的实例2：
```
L     D     R
E   O E   I I
E C   I H   N
T     S     G
```

可以看到，一个V对应6个字母：
```
L     (D)
E   O 
E C   
T    
```


也就是说，从L（第一行）的索引+6，就能走到D（第一行）
再确认一下：从E（第二行第1个）到E（第二行第2个）也是6，现在确定 4 行的Z 周期 是  6

再去看看其他实例 ：
```
L   C   I   R
E T O E S I I G
E   D   H   N
```


可以看出它的周期是4，那么3行对应周期4，4行对应周期6，我们就可以猜测n行对应周期（可以手画一个5行的，验证该公式也成立）
```
int step=(numRows-1)*2;
```
再来分析一下官方示例2：

//因为多空格会被识别为一个空格，影响排版，所以我用代码块，但是就失去了加粗的功能，我用<这个符号代表注意观察这几个字母

```
L<    D<    R
E   O E   I I
E C   I H   N
T     S     G
```

既然第一行这种中间没有间隔的（意思就是在一个周期内L和D之间没有间隔），满足了周期关系，那我们就可以根据定义一个索引index，
比如L，是第0位，然后0+6=6，添加第6位的，直到index>s.length()时停止。
显而易见，第一行和最后一行的分析是一样的。
下面分析中间的几行：
```
L     D     R
E<  O<E<  I I
E C   I H   N
T     S     G
```

我们知道，从左边那个E到右边那个E，是周期6，然后观察E到O，隔了4位，O到E，隔了2位：
也就是先走4步，记录下字母，再走6-4步，记录下字母

那我们怎么知道先是4，再是2呢？
再观察：
```
L     D     R
E   O E   I I
E<C<  I<H   N
T     S     G
```

E到C是隔了2位，C到I隔了4位，
也就是先走2步，记录下字母，再走6-2步，记录下字母

再仔细看一下：

```
E  O 
E C   
T  
```
```
E C   
T  
```
上面那个V，和下面这个V，只是少了俩字母而已，那么我们就知道，这个V短一行，我们就短2个字母位间隔
那么我们可以定义一个记录当前是第几行的int变量count（从0开始）
再定义一个leave变量，记录先走leave步，再走6-leave步
易得公式：leave=step-count*2;

下面理一下大体思路：
1.找周期step
2.将周期分成两部分，一部分走leave，一部分走step-leave步（第一行和最后一行不考虑，只考虑step步就行了，因为他没有中间字母）
3.总共走s.length()次，因为有这么多个字母


下面放上代码：
```
public String convert(String s, int numRows) {
        int len=s.length();
        if(numRows==1)return s;//如果只有1行，那不需要任何操作，直接return
        StringBuilder sb=new StringBuilder();
        int step=(numRows-1)*2;//公式，上面已推导
        int index=0;//索引，用来找下一个同一行的字母
        char[] cs=s.toCharArray();//转成char数组效率高一些
        int count=0;//记录当前是第几行，从0开始，第一行用0表示
        int leave=0;//先走leave步，再走step-leave步

        for (int i = 0; i < len; i++) {
            sb.append(cs[index]);
            if(count==0||count==numRows-1){//如果是第一行或者最后一行，只需要直接index+step就能找到下一个
                index+=step;
                if(index>=len){//如果大于等于len长度，说明到下一行了，count+1；索引换到下一行第一个
                    index=count+1;
                    count++;
                }
            }else {
                //如果是中间的那几行，先走leave步记录一下字母，再走step-leave步记录一下字母
                leave=step-count*2;//leave公式，上面已推导
                index+=leave;
                if(index>=len){//如果大于等于len，到下一行，并且该周期肯定没有下一个字母了，直接continue
                    index=count+1;
                    count++;
                    continue;
                }
                sb.append(cs[index]);//加入字母
                i++;//i是用来记录总共找几次字母的，一个周期找了俩字母，就需要再进行一次i++了
                index+=count*2;//count*2自然就是step-leave了
                if(index>=len){//换行，索引更新
                    index=count+1;
                    count++;
                }
                //我们更新的index轮到下一次循环的刚开始就append了，所以第二个字母就不需要再append一次
            }
        }

        return sb.toString();
    }
```


时间复杂度：O(n)，只遍历了一遍
空间复杂度：O(n)，用了StringBuilder


最后放一下运行图片：
![image.png](https://pic.leetcode-cn.com/1604673531-uumBUB-image.png)



