package edu.uiowa.slis.GRIDRDF.Archive;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class ArchiveHasRelatedType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static ArchiveHasRelatedType currentInstance = null;
	private static final Log log = LogFactory.getLog(ArchiveHasRelatedType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			ArchiveHasRelatedIterator theArchiveHasRelatedIterator = (ArchiveHasRelatedIterator)findAncestorWithClass(this, ArchiveHasRelatedIterator.class);
			pageContext.getOut().print(theArchiveHasRelatedIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Archive for hasRelated tag ", e);
			throw new JspTagException("Error: Can't find enclosing Archive for hasRelated tag ");
		}
		return SKIP_BODY;
	}
}

