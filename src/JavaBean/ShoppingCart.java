package JavaBean;

import JavaBean.Goods;
import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {
    private List<Goods> buyList = new ArrayList<>();

    public void setBuyList(List<Goods> buyList) {
        this.buyList = buyList;
    }
    /**
     * @param single
     */
    public void addItem(Goods single) {
        if (null != single) {
            if (0 == this.buyList.size()) {
                Goods tmp = new Goods();
                tmp.setName(single.getName());
                tmp.setPrice(single.getPrice());
                tmp.setNum(1);
                this.buyList.add(tmp);
            }
            else {
                int i = 0;
                for (; i < this.buyList.size(); ++i) {
                    Goods tmp = this.buyList.get(i);
                    if (tmp.getName().equals(single.getName())){
                        tmp.setNum(tmp.getNum() + 1);
                        break;
                    }
                }
                if (this.buyList.size() <= i) {
                    Goods tmp = new Goods();
                    tmp.setName(single.getName());
                    tmp.setPrice(single.getPrice());
                    tmp.setNum(1);
                    this.buyList.add(tmp);
                }
            }
        }
    }

    /**
     * @param name
     */
    public void removeItem(String name) {
        for (int i = 0; i < this.buyList.size(); ++i) {
            Goods tmp = this.buyList.get(i);
            if (tmp.getName().equals(name)) {
                if (1 < tmp.getNum()) {
                    tmp.setNum(tmp.getNum() - 1);
                    break;
                }
                else if (1 == tmp.getNum()) {
                    Goods removed = this.buyList.remove(i);
                }
            }
        }
    }
}
