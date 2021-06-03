package com.xuzj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*


REQUIRED 使用当前事务，如果当前没有事务，则自己新建一个事务。子方法是必须运行在一个事务中的。
                 如果当前存在事务，则加入这个事务，成为一个整体
                举例：领导没饭吃，我有钱，我会自己买了自己吃；领导有饭吃，会分给我一起吃
                主要用于增删改
SUPPORTS 如果当前有事务，则使用事务；如果当前没有事务，则不使用事务
                举例：领导没饭吃，我也没有；领导有饭吃，我也有
               主要用于查询
MANDATORY 调用方必须要有事务。如果不存在则抛出异常
                举例：领导必须管饭
 REQUIRES_NEW 如果当前有事务，则挂起该事务，创建一个新的事务给自己使用
                            如果当前没有事务，同REQUIRED
                举例：领导管饭  ，但是不要，我自己买了吃
NOT _SUPPORTED 如果当前有事务，则挂起该事务，自己不使用事务运行数据库操作
                 举例：领导管饭  ，但我太忙了，放一边 不吃
NEVER 调用方有事务，则报异常
               举例：领导管饭  ，我不想吃，抛出异常
NESTED 当前有事务，则开启子事务，嵌套事务  ，嵌套事务是独立提交或回滚。
            如果当前没有事务，则同REQUIRED
            如果主事务提交，则会携带子事务一起提交
            如果主事务回滚，则子事务会一起回滚，相反，子事务异常，则父事务可以回滚或不会滚(看事务有没有被catch掉)
            举例：领导犯错，老板怪罪，小弟一同受罪。小弟出错，领导可以推卸责任

 */
@Service
public class TestTransactionService {
    @Autowired
    private SysroleService sysroleService;

    @Transactional(rollbackFor = Exception.class)
    public void testTransactions(){
        sysroleService.saveParent();

        sysroleService.saveChild();
    }
}
