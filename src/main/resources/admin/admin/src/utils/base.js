const base = {
    get() {
        return {
            url : "http://localhost:8080/cangkuguanlixitong/",
            name: "cangkuguanlixitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/cangkuguanlixitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "仓库管理系统"
        } 
    }
}
export default base
