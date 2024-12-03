//我要用到的一些接口
import service from "@/request/index";
 
// 接口
export function login() {//接口ILoginData接口的变量名
    return service({
        url: "/index.php/index/index/index",      //写你自己的接口
        method: "GET" 
    })
}
 
// // 接口
// export function getGoodsList(){
//     return service({
//         url: "/getGoodsList",
//         method: "GET"
//     })
// }