import io.swagger.annotations.ApiModel;

<#assign className=table.className>
<#assign classNameLower=className?uncap_first>
        package ${basepackage}.${subpackage}.model.dto;
/**
 * Template Created By Miller
 * Auto Generate By Code-Generator
 */
<#list table.columns as column>
<#if column.pk>
<#assign pkType = column.javaType.simpleName>
</#if>
</#list>
@Accessors(chain = true)
@ApiModel(value = "${className}", description = "${table.remarks}")
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

    className}DTO implements Serializable{

	//columns START
	<#list table.columns as column>
	<#if column.remarks??>
	<#assign propertyName = column.remarks>
	<#else>
	<#assign propertyName = column.columnNameLower>
	</#if>
	@ApiModelProperty(value="${propertyName}")
	private ${column.javaType.simpleName} ${column.columnNameLower};

	</#list>
	//columns END
}

