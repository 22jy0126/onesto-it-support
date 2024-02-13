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
    goTo("/jobCases.html");
};

// 社員、お客様、管理者・ログイン
const goLogin = (emp) => {
    const url = emp == "1" ? "/login.html?emp=1" : "/login.html";
    goTo(url);
};

// 社員・社員の登録
const goEmployeeRegister = () => {
    goTo("/employeeRegister.html");
};

// 社員・社員の登録確認
const goEmployeeRegisterConfirm = () => {
    goTo("/employeeRegisterConfirm.html");
};

// 社員・社員の登録完了
const goEmployeeRegisterComplete = () => {
    goTo("/employeeRegisterComplete.html");
};

// 社員・社員の詳細
const goEmployeeInfo = () => {
    goTo(`/employeeInfo.html`);
};

// 社員・社員の応募歴史
const goEmployeeApplyHistory = () => {
    goTo("/employeeApplyHistory.html");
};

// 社員・案件の詳細
const goCaseDetail = (caseId, tom = "0") => {
    goTo(`/caseDetail.html?caseId=${caseId}&tom=${tom}`);
};

// 社員・案件のマイルストーン編集
const goMilestoneEdit = (caseId) => {
    goTo(`/milestoneEdit.html?caseId=${caseId}`);
};

// 社員・案件のマイルストー進捗更新
const goMilestoneProgressUpdate = (caseId) => {
    goTo(`/milestoneProgressUpdate.html?caseId=${caseId}`);
};

// 社員・通知
const goEmployeeNotification = () => {
    goTo("employeeNotification.html");
}

// お客様・お客様の登録
const goCustomerRegister = () => {
    goTo("/customerRegister.html");
};

// お客様・お客様の登録確認
const goCustomerRegisterConfirm = () => {
    goTo("/customerRegisterConfirm.html");
};

// お客様・お客様の登録完了
const goCustomerRegisterComplete = () => {
    goTo("/customerRegisterComplete.html");
};

// お客様・新規案件登録
const goCustomerCaseEdit = () => {
    goTo("/customerCaseEdit.html");
};

// お客様・案件応募者の詳細チェック
const goCustomerEmpInfo = (employeeId, caseId, binded = "") => {
    let url = `/customerEmpInfo.html?employeeId=${employeeId}&caseId=${caseId}`;
    if (binded == 1) {
        url = `${url}&binded=1`;
    }
    goTo(url);
};

// お客様・案件詳細
const goCustomerCaseDetail = (caseId = "", tom = "") => {
    let url = "/customerCaseDetail.html";
    if (caseId != "") {
        url = `${url}?caseId=${caseId}`;
    }
    if (tom != "") {
        url = `${url}&tom=${tom}`;
    }
    goTo(url);
};

// お客様・登録した案件リスト
const goCustomerCaseView = () => {
    goTo("/customerCaseView.html");
};

// お客様・案件のマイルストーン確認
const goMilestoneDetailConfirm = (caseId = "") => {
    goTo(`/milestoneDetailConfirm.html?caseId=${caseId}`);
};

// お客様・案件のマイルストーン進捗確認
const goMilestoneProgressConfirm = (caseId = "") => {
    goTo(`/milestoneProgressConfirm.html?caseId=${caseId}`);
};

// お客様・通知
const goCustomerNotification = () => {
    goTo(`/customerNotification.html`);
};

// 管理者・顧客管理
const goManageCustomer = () => {
    goTo("/manageCustomer.html");
};

// 管理者・社員管理
const goManageEmployee = () => {
    goTo("/manageEmployee.html");
};

// 管理者・顧客案件リスト
const goManageCustomerDetail = (customerId) => {
    goTo(`/manageCustomerDetail.html?customerId=${customerId}`);
};

// 管理者・社員案件リスト
const goManageEmployeeDetail = (employeeId) => {
    goTo(`/manageEmployeeDetail.html?employeeId=${employeeId}`);
};

const goManageCaseDetail = (caseId, from) => {
    goTo(`/manageCaseDetail.html?caseId=${caseId}&from=${from}`);
}
