问题描述：
某寺庙里7个和尚:轮流挑水，为了和其他任务不能冲突，各人将有空天数列出如下表：
和尚1: 星期二,四;
和尚2: 星期一,六;
和尚3: 星期三,日;
和尚4: 星期五;
和尚5: 星期一,四,六;
和尚6: 星期二,五;
和尚7: 星期三,六,日;
请将所有合理的挑水时间安排表
输入7行7列，0代表和尚今天不挑水，1代表可以挑水，A和尚挑完水本周就不挑了，问有多少种挑水方法，排列组合是什么。

这题比较纠结的是如何先输出挑水的总数，然后输出挑水的安排。
如果用回溯法进行递归的话，只能count++或者输出满足条件的情况，但是肯定不能先输出总是再输出安排。
我能想到就是比较笨的方法，同一种方法使用两次，这里就不写那种方法了，只写输出安排，最后输出总数的方法，有好方法的话还望赐教。
回到本题，用回溯法做比较方便，周一选出一个合适的和尚，再周二选合适的和尚，直到周末，
这个合适指的是和尚该天可以挑水而且之前没挑过，可以用两个数组存放其状态，状态符合的话就往下走。
用递归和for循环实现遍历所以情况，判断是否适合。程序代码如下：