CREATE TABLE `cw_ge_setting` (
	`setting_key` VARCHAR(50) NOT NULL COMMENT '健',
	`setting_value` VARCHAR(50) NULL DEFAULT NULL COMMENT '值',
	`remark` VARCHAR(50) NULL DEFAULT NULL COMMENT '说明',
	PRIMARY KEY (`setting_key`)
)
COMMENT='系统参数配置'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
