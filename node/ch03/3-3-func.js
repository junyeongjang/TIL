const {odd, even} = require('./3-3-var');

function checkOddOrEven(num){
    if(num % 2 ) {
        return odd;
    }
    return even;
}
module.exports = checkOddOrEven;