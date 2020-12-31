package com.spiderman.security.dto;

import lombok.Data;

/**
 * 权限DTO
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.security.dto.PermissionDto,v 0.1 12/31/20 11:35 AM Exp $$
 */
@Data
public class PermissionDto {
    private String id;
    private String code;
    private String description;
    private String url;
}
