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
const goLogin = (emp) => {
    const url = emp == "1" ? "/login.html?emp=1" : "/login.html";
    goTo(url);
};

// 社員・社員の登録
const goEmployeeRegister = () => {
    goTo("/employeeregister.html");
};

// 社員・社員の登録確認
const goEmployeeRegisterConfirm = () => {
    goTo("/employeeregisterconfirm.html");
};

// 社員・社員の登録完了
const goEmployeeRegisterComplete = () => {
    goTo("/employeeregistercomplete.html");
};

// 社員・社員の詳細
const goEmployeeInfo = () => {
    goTo(`/employeeinfo.html`);
};

// 社員・社員の応募歴史
const goEmployeeApplyHistory = () => {
    goTo("/employeeapplyhistory.html");
};

// 社員・案件の詳細
/**
 * @Param from
 * 1 案件一覧
 * 2 応募歴史
 * 
 * @Param caseId
 */
//
const goCaseDetail = (caseId) => {
    goTo(`/casedetail.html?caseId=${caseId}`);
};

// 社員・案件のマイルストーン編集
const goMilestoneEdit = (caseId) => {
    goTo(`/milestoneedit.html?caseId=${caseId}`);
};

// 社員・案件のマイルストー進捗更新
const goMilestoneProgressUpdate = () => {
    goTo("/milestoneprogressupdate.html");
};

// 社員・通知
const goEmployeeNotification = () => {
    goTo("employeenotification.html");
}

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

// お客様・案件応募者の詳細チェック
const goCustomerEmpInfo = (employeeId, caseId) => {
    goTo(`/customerempinfo.html?employeeId=${employeeId}&caseId=${caseId}`);
};

// お客様・案件詳細
const goCustomerCaseDetail = (caseId = "") => {
    let url = "/customercasedetail.html";
    if (caseId != "") {
        url = `${url}?caseId=${caseId}`;
    }
    goTo(url);
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

// 管理者・顧客管理
const goManageCustomer = () => {
    goTo("/managecustomer.html");
};

const goManageEmployee = () => {
    goTo("/manageemployee.html");
};
