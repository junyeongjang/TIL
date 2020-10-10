const { odd, even } =require('./3-3-var');
const checkNumber = require('./3-3-func');

function checkStringOddOrEven(str){
    if (str.length % 2){
        return odd;
    }
    return even;
}
console.log(checkNumber(10));
console.log(checkStringOddOrEven('hello'));
