<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
    <head><title>Form!</title></head>
    <body>
       <form action="/favorite_fruit" method="post">
           <p> What is your favorit fruit</p>
           <#list fruits as fruit>
               <p>
                   <input type="radio" name="fruit" value="${fruit}"/> ${fruit}
               </p>
           </#list>
            <input type="submit" value="Submit"/>
       </form>
    </body>
</html>