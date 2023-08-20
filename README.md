# RESTful API для социальной медиа платформы

### Функционал приложения

- Пользователи могут отправлять заявки в друзья другим пользователям. С этого момента, пользователь, отправивший заявку, остается подписчиком до тех пор, пока сам не откажется от подписки. Если пользователь, получивший заявку, принимает ее, оба пользователя становятся друзьями. Если отклонит, то пользователь, отправивший заявку, как и указано ранее, все равно остается подписчиком.
- Пользователи, являющиеся друзьями, также являются подписчиками друг на друга.
- Если один из друзей удаляет другого из друзей, то он также отписывается. Второй пользователь при этом должен остаться подписчиком.
- Друзья могут писать друг другу сообщения
- Пользователи могут создавать новые посты.
- Пользователи могут просматривать посты других пользователей(реализована пагинация по 3 поста на страницу).
- Пользователи могут обновлять и удалять свои собственные посты.


### Технологии: 
Java, Maven, MySQL, Spring Boot, Spring Securiry, JWT,  Hibernate, JPA, 
 Lombok, Mapstruct, Swagger.




### Запуск проекта
1. Запустить проект после сборки
3. Документация Swagger:  http://127.0.0.1:8080/swagger-ui/index.html#/ 
