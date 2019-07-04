import com.baomidou.mybatisplus.annotations.TableName;

<#assign className=table.className>
<#assign classNameLower=className?uncap_first>
        package ${basepackage}.${subpackage}.model.entity;
/**
 * Template Created By Miller
 * Auto Generate By Code-Generator
 */
<#list table.columns as column>
<#if column.pk>
<#assign pkType = column.javaType.simpleName>
</#if>
</#list>
@TableName("${table.sqlName}")
@Accessors(chain = true)
public class ${
    public $() {
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof $)) return false;
        final $ other = ($) o;
        if (!other.canEqual((Object) this)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof $;
    }

    public int hashCode() {
        int result = 1;
        return result;
    }

    public String toString() {
        return "$()";
    }

    className} implements Serializable{

	//columns START
	<#list table.columns as column>
	<#if column.remarks??>
<#if column.remarks!="">
	/**
	 * ${column.remarks}
	 */
	</#if>
</#if>
	<#if column.pk>
	@TableId(type = IdType.AUTO)
	<#else>
    @TableField("${column.sqlName}")
	</#if>
	private ${column.javaType.simpleName} ${column.columnNameLower};

	</#list>
	//columns END
}

