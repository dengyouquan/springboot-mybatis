#docker run -p 6379:6379 -v $PWD/data:/data  -d registry.saas.hand-china.com/tools/redis:4.0.2 redis-server --appendonly yes
docker run -p 6379:6379  -d registry.saas.hand-china.com/tools/redis:4.0.2 redis-server --appendonly yes