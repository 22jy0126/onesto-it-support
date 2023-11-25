# **　モクアップの作る手順
##　①HTMLファイルを作り、example.html ファイルの全ての内容をコピーし、自分のHTMLファイルに貼り付ける
##　②HTMLファイルと同じ名前のCSSファイルを作る。
##　③HTMLファイルの中で、TODO の部分を完成する

Tips
属性の意味
①　:src="user.avatarUrl" :はデータ化するの意味、その値はdataのメソッドでreturnのオブジェクトの中にあります
```
vm = new Vue({
// id はapp の属性の中の部分を管理する
el: "#app",
data(){
    return {
	// ログインしたユーザー情報
	user: {
			// 注意：ここはuser.avatarUrlの値です
	    avatarUrl: "https://cube.elemecdn.com/3/7c/3ea6b726f1epng.png", 
	},
	
    };
},
});
```
    
 ② v-model formの値を同期化する
```
 <el-input-number v-model="searchJobCase.minMoney"></el-input-number>
```
 
 ユーザーはinputの値を修正する同時にdataのメソッドでreturnのオブジェクトの中の値自動的に修正する
```
 vm = new Vue({
        // id はapp の属性の中の部分を管理する
        el: "#app",
        data(){
            return {
                // ログインしたユーザー情報
                searchJobCase: {
                		// 注意：ここはsearchJobCase.minMoneyの値で、ユーザーの修正と同時に修正する
                    minMoney: 2, 
                },
                
            };
        },
    });
```
    
自動的に繰り返し
// jobList のデータで、HTMLの自動的に繰り返して生成する
```
<div class="job-case-item" v-for="job in jobList">
	<span>{{job.bonusMoney.toLocaleString()}}万円</span>　
    <span>{{job.bonusMoneyNegotiable ? "(相談可能)" : ""}}</span> 
</div>
```
```
vm = new Vue({
        // id はapp の属性の中の部分を管理する
        el: "#app",
        data(){
            return {
                // 求人票のデータ
                jobList: [{
                    bonusMoney: 5,                    //　報酬
                    bonusMoneyNegotiable: true,             //　報酬相談可能
                }, {
                    bonusMoney: 7.5,                    //　報酬
                    bonusMoneyNegotiable: false,             //　報酬相談可能                                               
                }, {
                    bonusMoney: 5,                    //　報酬
                    bonusMoneyNegotiable: true,             //　報酬相談可能
                }, {
                    bonusMoney: 7.5,                    //　報酬
                    bonusMoneyNegotiable: false,             //　報酬相談可能                                               
                }],
            };
        },
    });
```
                                

