/**
 * 画面遷移
 * */
const goTo = (url) => {
    window.location = url;
};
/**
 * 誰からアクセス・画面
* */
// 社員・求人一覧
const goJobCases = () => {
    goTo("/jobcases.html");
};

// 社員、お客様、管理者・ログイン
const goLogin = () => {
    goTo("/login.html");
};

// 社員・社員の登録
const goEmployeeRegister = () => {
    goTo("/employeeregister.html");
};

// 社員・社員の登録確認

// 社員・社員の登録完了

// 社員・社員の詳細
const goEmployeeInfo = () => {
    goTo("/employeeinfo.html");
};

// 社員・社員の応募歴史
const goEmployeeApplyHistory = () => {
    goTo("/employeeapplyhistory.html");
};

// 社員・案件の詳細
/**
 * @Param applystatus
 * 0 未応募
 * 1 既に応募した、結果出てこない
 * 2 既に応募した、不採用した
 * 3 既に応募した、案件開始中
 * 4 既に応募した、案件終わり
 **
 * @Param from
 * 1 案件一覧
 * 2 応募歴史
 */
//
const goCaseDetail = (applystatus, from) => {
    goTo(`/casedetail.html?applystatus=${applystatus}&from=${from}`);
};

// 社員・案件のマイルストーン編集
const goMilestoneEdit = () => {
    goTo("/milestoneedit.html");
};

// 社員・案件のマイルストー進捗更新
const goMilestoneProgressUpdate = () => {
    goTo("/milestoneprogressupdate.html");
};

// 社員・通知

// お客様・お客様の登録
const goCustomerRegister = () => {
    goTo("/customerregister.html");
};

// お客様・お客様の登録確認
const goCustomerRegisterConfirm = () => {
    goTo("/customerregisterconfirm.html");
};

// お客様・お客様の登録完了
const goCustomerRegisterComplete = () => {
    goTo("/customerregistercomplete.html");
};

// お客様・新規案件登録
const goCustomerCaseEdit = () => {
    goTo("/customercaseedit.html");
};

// お客様・案件詳細
const goCustomerCaseDetail = () => {
    goTo("/customercasedetail.html");
};

// お客様・登録した案件リスト
const goCustomerCaseView = () => {
    goTo("/customercaseview.html");
};

// お客様・案件のマイルストーン確認
const goMilestoneDetailConfirm = () => {
    goTo("/milestonedetailconfirm.html");
};

// お客様・案件のマイルストーン進捗確認
const goMilestoneProgressConfirm = () => {
    goTo("/milestoneprogressconfirm.html");
};

// お客様・通知
