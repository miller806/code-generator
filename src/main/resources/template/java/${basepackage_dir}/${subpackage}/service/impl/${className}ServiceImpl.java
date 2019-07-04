import org.springframework.stereotype.Service;

<#assign className=table.className>
<#assign classNameLower=className?uncap_first>
        package ${basepackage}.${subpackage}.service.impl;
        {basepackage}.${subpackage}.model.entity.${className};
        {basepackage}.${subpackage}.mapper.${className}Mapper;
        {basepackage}.${subpackage}.service.${className}Service;
/**
 * Template Created By Miller
 * Auto Generate By Code-Generator
 */
@Service
public class ${className}ServiceImpl extends ServiceImpl<${className}Mapper, ${className}> implements ${className}Service{
<#assign hasPkColumn = false>
<#assign hasCreateTimeColumn = false>
<#assign hasUpdateTimeColumn = false>
<#list table.columns as column>
<#if column.pk>
<#assign hasPkColumn = true>
</#if>
<#if column.columnNameLower == 'createTime'>
<#assign hasCreateTimeColumn = true>
</#if>
<#if column.columnNameLower == 'updateTime'>
<#assign hasUpdateTimeColumn = true>
</#if>
</#list>
    <#if hasPkColumn && hasCreateTimeColumn>
    @Transactional(rollbackFor = {BizException.class, Exception.class})
    @Override
    public boolean insert(${className} entity) {
    <#if hasUpdateTimeColumn>
        Date now = DateUtils.nowWithTime();
        // 设置创建时间
        entity.setCreateTime(now);
        // 设置更新时间
        entity.setUpdateTime(now);
    <#else>
        // 设置创建时间
        entity.setCreateTime(DateUtils.nowWithTime());
    </#if>
        return super.insert(entity);
    }
    </#if>

    <#if hasPkColumn>
    @Transactional(rollbackFor = {BizException.class, Exception.class})
    @Override
    public boolean insertOrUpdate(${className} entity) {
        if (entity.getId() == null ) {
            return this.insert(entity);
        }
        return this.updateById(entity);
    }
    </#if>
    <#if hasUpdateTimeColumn>
    @Transactional(rollbackFor = {BizException.class, Exception.class})
    @Override
    public boolean updateById(${className} entity) {
        entity.setUpdateTime(DateUtils.nowWithTime());
        return super.updateById(entity);
    }
    </#if>

}
