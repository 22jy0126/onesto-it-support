function dateFormat(time) {
    const numTo2 = (num) => {
        if ((+num) < 10) {
            const res = "0" + num;
            return res;
        }
        return num;
    };

    const dateTime = new Date(time);
    const year = dateTime.getFullYear();
    let month = dateTime.getMonth();
    month = numTo2(month);
    let day = dateTime.getDay();
    day = numTo2(day);
    return year + "年" + month + "月" + day + "日";
}

function dateFormat2(time) {
    const numTo2 = (num) => {
        if ((+num) < 10) {
            const res = "0" + num;
            return res;
        }
        return num;
    };

    const dateTime = new Date(time);
    const year = dateTime.getFullYear();
    let month = dateTime.getMonth();
    month = numTo2(month);
    return year + "年" + month + "月";
}

function getURLParam(key) {
    const url = new URL(window.location.href);
    const params = url.searchParams;
    return params.get(key);
}
