package edu.uiowa.slis.GRIDRDF.Archive;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class ArchiveHasRelatedInverseType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static ArchiveHasRelatedInverseType currentInstance = null;
	private static final Log log = LogFactory.getLog(ArchiveHasRelatedInverseType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			ArchiveHasRelatedInverseIterator theArchiveHasRelatedInverseIterator = (ArchiveHasRelatedInverseIterator)findAncestorWithClass(this, ArchiveHasRelatedInverseIterator.class);
			pageContext.getOut().print(theArchiveHasRelatedInverseIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Archive for hasRelated tag ", e);
			throw new JspTagException("Error: Can't find enclosing Archive for hasRelated tag ");
		}
		return SKIP_BODY;
	}
}

