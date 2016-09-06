package cn.edu.uestc.acm.cdoj_android.layout.detail;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Map;

import cn.edu.uestc.acm.cdoj_android.Global;
import cn.edu.uestc.acm.cdoj_android.R;
import cn.edu.uestc.acm.cdoj_android.layout.list.ListFragmentWithGestureLoad;
import cn.edu.uestc.acm.cdoj_android.layout.list.PullUpLoadListView;
import cn.edu.uestc.acm.cdoj_android.net.ViewHandler;

/**
 * Created by great on 2016/8/25.
 */
public class ContestClarification extends ListFragmentWithGestureLoad {
    private SimpleAdapter adapter;
    private int contestID = -1;
    private ArrayList<Map<String, Object>> listItems = new ArrayList<>();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState == null) {
            setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    listItems.clear();
                    continuePullUpLoad();
                    Global.netContent.getContestPart(ViewHandler.CONTEST_COMMENT, contestID, 1);
                }
            });
            setOnPullUpLoadListener(new PullUpLoadListView.OnPullUpLoadListener() {
                @Override
                public void onPullUpLoading() {
                    Log.d("讨论下拉加载", "onPullUpLoading: "+getPageInfo().currentPage);
                    Global.netContent.getContestPart(ViewHandler.CONTEST_COMMENT,contestID, getPageInfo().currentPage+1);
                }
            });
            if (contestID != -1) {
                Global.netContent.getContestPart(ViewHandler.CONTEST_COMMENT, contestID, 1);
            }
        }
    }

    @Override
    public void addListItem(Map<String, Object> listItem) {
        listItems.add(listItem);
    }

    @Override
    public void notifyDataSetChanged() {
        if (adapter == null) {
            createAdapter();
        }
        adapter.notifyDataSetChanged();
        super.notifyDataSetChanged();
    }

    private void createAdapter() {
        adapter = new SimpleAdapter(
                Global.currentMainActivity, listItems, R.layout.contest_clarification_item_list,
                new String[]{/*"header",*/ "content", "date", "author"},
                new int[]{/*R.id.contestClarification_header,*/ R.id.contestClarification_content,
                        R.id.contestClarification_date, R.id.contestClarification_author});
        setListAdapter(adapter);
    }

    public void setContestID(int id) {
        contestID = id;
        if (getListView() != null) {
            Global.netContent.getContestPart(ViewHandler.CONTEST_COMMENT, contestID, 1);
        }
    }
}
