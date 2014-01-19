<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html  xmlns="http://www.w3.org/1999/xhtml" lang="en">
    <head>
        <title>Welcome!</title>
        <script>

            function solution(A) {
                var inspectObj = {0:true,1:true,2:true,3:true,4:true,5:true,6:true,7:true,8:true,9:true},
                        joinArr = A.join("_"),
                        finalResult = {item:-1},
                        counter=false,
                        regex;

                for (idx in inspectObj){
                    regex = new RegExp(idx, 'g');

                    if(joinArr.match(regex) === null){
                        delete inspectObj[idx];
                    } else if(joinArr.match(regex).length>1){
                        delete inspectObj[idx];
                    }else{
                        inspectObj[idx] = joinArr.indexOf(idx);
                    }

                }

                for (idx in inspectObj){

                    if (counter==false){
                        counter={};
                        counter.item = idx;
                        counter.idx  = inspectObj[idx];
                    }

                    counter.item = (inspectObj[idx] < counter.idx)?idx : counter.item;
                    counter.idx  = (inspectObj[idx] < counter.idx)?inspectObj[idx] : counter.idx;
                }
                return counter===false?-1:counter.item;
            }


          solution([1,4,3,3,1,2,4,3,3,1,9]);
        </script>

    </head>
    <body>
        <h1>Hello ${name}</h1>
    </body>
</html>