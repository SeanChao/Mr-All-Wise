package xyz.sean.zx.mrall_wise;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    private List<ZCYQuotes> quoteList = new ArrayList<>();
    private String content[] = {"做好课前准备","上课！（降调）","（……五分钟新课……）",
            "上午第一节就犯困！","先说这个dīng正作业","我一个礼拜就收这样的一次，有的同学就订正了3道题，你真的就只错了3道题？",
            "接下来我们处理作业", "我把答案写在黑板上，同学们批改一下","（下来兜一圈）","对的题要打对er号！",
            "一道一道地改！","我都兜了一圈了有的同学还没改完！（你慢你不行）","我来讲一下错的比较多的问题",
            "有些同学上来第一题就错！", "审题不清！","总gǎn觉到同学们公式不熟！","公式公式就是这种形式，连次序都不rún许改！",
            "我觉得没什么好讲的","在我眼里没有难题！","第3题，错的举手！","将近有一半的同学错了","不举？你给我等着！","这个问题我强调了多少遍！",
            "总gán觉到同学们对于我说过的问题不给予足够的重视！","这道题考试前一天刚讲过！","我没讲过别的方法，就讲过π-",
            "不rún许有并！我看谁有病！", "k∈Z不要忘写！","定义域要用集合给出！","下面看试卷",
            "要养成写名字的好习惯，拿到卷子写上名字","下次谁不写名字就撕掉！","卷子叠叠好！","xxx字写写好",
            "xxx你看看你，就没对几个！", "xxx，你还会些啥？","我先设一个t","把这个式子展开，就能dě到这样一件事情",
            "我们来yān究这样一个函数","研究函数先研究定义域！","cnr，把腿放下来","总gán觉到同学们对数学学习没有热情！",
            "就说我们的课代表，能代表些啥？","我们没有形成数学学习的氛围","应该要有这样的领头羊",
            "今天的作业，一课一练，就这样的两套题", "有些同学去网上搜答案，你下次碰到了还得错！","你不明白为什么要这么做！",
            "（跟1班的）差距一次比一次大！","迷信点说，是不是我们命中注定要这样", "同学们写份反思","我的作业真的很少了",
            "还gě那er玩游戏！","希望同学们能批评我","你们给我提的意见，让我上课多讲些例题。接下来我都不在了。（笑）",
            "zcy无辜的表情：我哪里写错了？ \nzcy诧异的眼神：怎么了？我又写错了？\nzcy邪魅的笑容：你看错两次就对了...\nzcy大怒，粉笔一扔：又写错了，这题不讲了，你们自己讨论",
            "不要为了完成作业而ěr去完成作业！",
            "The set is infinite" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        initQuotes(); // 初始化梗数据
        QuoteAdapter adapter = new QuoteAdapter(MainActivity.this,
                R.layout.quote_item, quoteList);

        mListView = (ListView) findViewById(R.id.listview);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "传义大法好！", Snackbar.LENGTH_LONG)
                        .setAction("是的！",new View.OnClickListener(){
                            @Override
                            public void onClick(View view){
                                Toast.makeText(MainActivity.this,"那你还毛都不会？",Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
            }
        });

        //ListView Setup
        mListView.setAdapter(adapter);
        fixListViewHeight(mListView);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void fixListViewHeight(ListView listView) {
        // 如果没有设置数据适配器，则ListView没有子项，返回。
        ListAdapter listAdapter = listView.getAdapter();
        int totalHeight = 0;
        if (listAdapter == null) {
            return;
        }
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            View listViewItem = listAdapter.getView(i , null, listView);
            // 计算子项View 的宽高
            listViewItem.measure(0, 0);
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);



    }

    private void initQuotes() {

        for(int i = 0 ; i < content.length ; i++){
            newQoute(content[i]);
        }
    }
    private ZCYQuotes newQoute(String content){
        ZCYQuotes quote = new ZCYQuotes(content);
        quoteList.add(quote);
        return quote;
    }

}
