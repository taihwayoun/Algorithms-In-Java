let readline = require('readline');

process.stdin.setEncoding('utf8');
let rl = readline.createInterface({
    input: process.stdin,
    terminal: false
  });

function readArray (line) {
    let numArray=[];
    if (line !== "\n") {
        let arr = line.toString().split(' ');
        //let len = parseInt(arr[0]);
        for (let i=0; i<arr.length; ++i){
            numArray.push(parseInt(arr[i]));
        }
    }
    return numArray;
}

function inversions(arr){
    //console.log(arr);
    if (arr.length<=1) return {'array': arr, 'count': 0};
    else{
        let cut=Math.floor(arr.length/2);
        let left=inversions(arr.slice(0,cut));
        let right=inversions(arr.slice(cut));
        let merged={'array':[], 'count':0};
        while (left.array.length > 0 && right.array.length>0){
            if (left.array[0]>right.array[0]) {
                merged.array.push(right.array[0]);
                right.array.shift();
                merged.count += left.array.length;
            }
            else {
                merged.array.push(left.array[0]);
                left.array.shift();
            }
        }
        merged.array = [...merged.array,...left.array, ...right.array];
        merged.count = merged.count + left.count + right.count;
        //console.log(merged.count);
    return merged;
}
}


function mergeSort(arr){
    if (arr.length<=1) return arr;
    else{
        let cut=Math.floor(arr.length/2);
        let left=inversions(arr.slice(0,cut));
        let right=inversions(arr.slice(cut));
        let merged=[];
        while (left.length >= 0 && right.length>0){
            if (left[0]<right[0]) {
                merged.push(left[0]);
                left.shift();
            }
            else {
                merged.push(right[0]);
                right.shift();
            }
        }
        merged = [...merged,...left, ...right];
    return merged;
}
}

