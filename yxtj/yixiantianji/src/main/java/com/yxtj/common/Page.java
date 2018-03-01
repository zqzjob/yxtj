package com.yxtj.common;

import java.util.ArrayList;
import java.util.List;

public class Page <T>{
    private Integer page;   //当前页
    private Integer size = 5;//每页默认为5
    private Integer max; //最大页数
    private Integer count;   //项目条数
    private String url; //地址
    private List<Integer> indexs;//要显示的页码
    private Integer indexNum ;//可现实页码范围内的数量
    private List<T> list;
    private String where;
    //在无参构造中初始化，当然我也在 BaseController 中初始化，
    //两种方式皆可，反正我都写上了
    //当然可以写在配置文件中，这是更好的，
    //方便起见就没有写配置文件了
    public Page() {
        page = 1;
        size = 5;
        indexNum = 5;
        where = " 1=1 ";
    }

    /**
     * 计算显示的导航页码
     */
    private void count() {
        Integer page = getPage();
        Integer max = getMax();
        if ( page!=null && max!=null ) {
            int begin = Math.max(page-indexNum, 1);
            int end = Math.min(page+indexNum, max);
            indexs = new ArrayList<>();
            for( int i = begin ; i <= end ; i++ ) {
                indexs.add(i);
            }
        }
    }
    public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Integer> getIndexs() {
		return indexs;
	}

	public void setIndexs(List<Integer> indexs) {
		this.indexs = indexs;
	}

	public Integer getIndexNum() {
		return indexNum;
	}

	public void setIndexNum(Integer indexNum) {
		this.indexNum = indexNum;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public Integer getPage() {
		return page;
	}

	public Integer getMax() {
		return max;
	}

	public void setPage(Integer page) {
        this.page = page;
        count(); //计算页码
    }
    public void setMax(Integer max) {
        this.max = max;
        count(); //计算页码
    }
    
    
}
