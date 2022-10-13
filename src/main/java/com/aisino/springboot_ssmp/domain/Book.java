package com.aisino.springboot_ssmp.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@ApiModel(value = "book",description = "书本实体类")
public class Book {

    @ApiModelProperty("书本ID")
    private Integer id;

    @ApiModelProperty("书本类型")
    private String type;

    @ApiModelProperty("书本名称")
    private String name;

    @ApiModelProperty("书本描述")
    private String description;
}
