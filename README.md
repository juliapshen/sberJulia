# sberJulia
Проект выполнен в соответствии с заданием курсовой работы для микросервиса Content Delivery System.<br/>
## Описание
Проект включает один контроллер, который содержит пять методов. <br/>
## Технологии 
В процессе разработки применялись следующие технологии:<br/>
- язык программирования java;<br/>
- spring framework java;<br/>
- СУБД MySQL.<br/>
## Запуск проекта
Запуск проекта осуществляется при настройке файла "application.properties", который хранит подключение к базе данных. <br/>
## Документация
Контроллер имеет название ContentDeliveryService. Путь к контроллеру: /contentDelivery <br/><br/><br/>
Для хранения и получения информации о содержимом контента от CMS применяется метод "dataContentFromCMS". <br/>
Обращение к методу происходит по пути: /contentDelivery/dataContentFromCMS <br/>
Методу отпраляется следующая структура:
```
{
    "content": [
        {
        "contentGuid": "86a3f1bc-0c6a-4954-8d8c-547d7a515ad5",
        "data": "'header': 'Текст заголовка', 'backgroundImg': '1.jpeg','text':'Текст'"
        },
        {
        "contentGuid": "6870c797-50fa-41c6-b62d-1d560e1a987a",
        "data": "'header': 'Текст заголовка', 'backgroundImg': '1.jpeg','text':'Текст'"
        }
    ]
}
```
ResponseEntity является ответом от сервера. <br/><br/><br/>
Для хранения и получения информации о таргете от AMS применяется метод "saveTargetFromAMS". <br/>
Обращение к методу происходит по пути: /contentDelivery/saveTargetFromAMS <br/>
Методу отпраляется следующая структура:
```
{
    "page": "MAIN_PAGE",
    "startDate": "22022022",
    "endDate": "23022022",
    "target": [
        {
            "userGuid": "28ca38ba-15dd-4cea-ab69-64630e0e7b37",
            "offers": [
                {
                "contentGuid": "79cfd31a-85f2-455c-8cf7-45982b278276",
                "priority": "99"
                },
                {
                    "contentGuid": "961ce6df-08a5-4278-b58e-588f2e021283",
                    "priority": "1"
                }
            ]
        },
        {
            "userGuid": "28ca38ba-15dd-4cea-ab69-64630e0e7b37",
            "offers":[
                {
                    "contentGuid": "79cfd31a-85f2-455c-8cf7-45982b278276",
                    "priority": "99"
                },
                {
                    "contentGuid": "961ce6df-08a5-4278-b58e-588f2e021283",
                    "priority": "1"
                }

            ]
        }
    ]

}
```
ResponseEntity является ответом от сервера. <br/><br/><br/>
Для передачи таргета пользователю применяется метод "getOffers". <br/>
Обращение к методу происходит по пути: /contentDelivery/getOffers <br/>
Методу POST отпраляется следующая структура:
```
{
    "page":"test1",
    "user_guid":"0c12f9b1-ffb8-11ec-9d96-0c9d92326ce8"
}
```
Возвращается следующая структура:
```
{
    "offers": [
        {
            "content": {
                "data": "'header': 'Текст заголовка', 'backgroundImg': '1.jpeg','text':'Текст'",
                "loadDate": "21022022",
                "priority": 99
            }
        },
        {
            "content": {
                "data": "'header': 'Текст заголовка', 'backgroundImg': '1.jpeg','text':'Текст'",
                "loadDate": "01011970",
                "priority": 99
            }
        }
    ]
}
```
<br/><br/><br/><br/>
Для фиксации просмотра таргетированного предложения применяется метод "saveViewed".<br/>
Обращение к методу происходит по пути: /contentDelivery/saveViewed <br/>
Методу отпраляется следующая структура:
```
{
    "viewed":[
        {
            "contentGuid": "05099fcd-2185-42f2-95a8-b616d67ce49d",
            "userGuid":"28ca38ba-15dd-4cea-ab69-64630e0e7b48"
        },
        {
            "contentGuid":"05099fcd-2185-42f2-95a8-b616d67ce49c",
            "userGuid":"28ca38ba-15dd-4cea-ab69-64630e0e7b37"
        }
    ]
}
```
ResponseEntity является ответом от сервера. <br/><br/><br/>
Для выгрузки информации о просмотрах в AMS применяется метод "method". <br/>
Обращение к методу происходит по пути: /contentDelivery/method <br/>
Метод возвращает следующую структуру:
```
{
    "viewed": [
        {
            "contentGuid": "11d2eb66-ffba-11ec-9d96-0c9d92326ce8",
            "userGuid": "0b198a31-ffb8-11ec-9d96-0c9d92326ce8"
        },
        {
            "contentGuid": "1476c039-ffba-11ec-9d96-0c9d92326ce8",
            "userGuid": "0b198a31-ffb8-11ec-9d96-0c9d92326ce8"
        },
        {
            "contentGuid": "1491bcc8-ffba-11ec-9d96-0c9d92326ce8",
            "userGuid": "0b198a31-ffb8-11ec-9d96-0c9d92326ce8"
        },
        {
            "contentGuid": "14a7b43f-ffba-11ec-9d96-0c9d92326ce8",
            "userGuid": "0b198a31-ffb8-11ec-9d96-0c9d92326ce8"
        }
    ]
}
```

