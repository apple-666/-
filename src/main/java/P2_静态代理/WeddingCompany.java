package P2_静态代理;

/**
 * 婚庆公司   帮助 我们完成整体结婚流程
 * 代理角色
 */
class WeddingCompany implements Marry{

    private Marry target;

    @Override
    public void happyMarry() {

        before();
        this.target.happyMarry();
        after();

    }

    private void before() {
        System.out.println("婚庆公司布置会场，准备灯光等一切事宜。。。。。");
    }

    private void after() {
        System.out.println("婚庆公司收拾会场，结婚完美结束，收取尾款。。。。。happyEnding！");
    }

    public WeddingCompany(Marry target) {
        this.target = target;
    }
}