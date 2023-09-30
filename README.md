Для локального запуска запустит Docker и в Idea запустить проект. БД должна автоматически подняться в докере

Если что-то пошло не по плану бд можно запустить выполнив скрипт

docker run -d --name otus-postgres -e POSTGRES_PASSWORD=otus -e POSTGRES_USER=otus -e POSTGRES_DB=otus -p 5432:5432 postgres
