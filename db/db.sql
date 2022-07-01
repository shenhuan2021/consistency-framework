CREATE TABLE `consistency_task`
(
    `id`                     bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '主键自增',
    `task_id`                varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户自定义的任务名称，如果没有则使用方法签名',
    `task_status`            int                                                           NOT NULL DEFAULT '0' COMMENT '执行状态',
    `execute_times`          int                                                           NOT NULL COMMENT '执行次数',
    `execute_time`           bigint                                                        NOT NULL COMMENT '执行时间',
    `parameter_types`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '参数的类路径名称',
    `method_name`            varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '方法名',
    `method_sign_name`       varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '方法签名',
    `execute_interval_sec`   int                                                           NOT NULL DEFAULT '60' COMMENT '执行间隔秒',
    `delay_time`             int                                                           NOT NULL DEFAULT '60' COMMENT '延迟时间：单位秒',
    `task_parameter`         varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '任务参数',
    `performance_way`        int                                                           NOT NULL COMMENT '执行模式：1、立即执行 2、调度执行',
    `thread_way`             int                                                           NOT NULL COMMENT '线程模型 1、异步 2、同步',
    `error_msg`              varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '执行的error信息',
    `alert_expression`       varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '告警表达式',
    `alert_action_bean_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '告警逻辑的的执行beanName',
    `fallback_class_name`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '降级逻辑的的类路径',
    `fallback_error_msg`     varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '降级失败时的错误信息',
    `shard_key`              bigint                                                                 DEFAULT '0' COMMENT '任务分片键',
    `created_time`           datetime                                                      NOT NULL COMMENT '创建时间',
    `updated_time`           datetime                                                      NOT NULL COMMENT '修改时间',
    `created_by`             varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '创建人',
    `updated_by`             varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '更新人'
        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;